package esgi.al2.kernel

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validator

internal class DefaultCommandBus<C : Command>(
    registry: MutableMap<Class<C>, CommandHandler<C, *>>,
    validator: Validator
) : CommandBus<C> {
    private val registry: MutableMap<Class<C>, CommandHandler<C, *>>
    private val validator: Validator

    init {
        this.registry = registry
        this.validator = validator
    }

    override fun <R> post(command: C): R {
        val violations: Set<ConstraintViolation<C>> = validator.validate(command)
        if (violations.isNotEmpty()) {
            throw ApplicationException(violations.toString())
        }
        return try {
            val commandHandler: CommandHandler<C, R>? = registry[command.javaClass] as CommandHandler<C, R>?
            commandHandler?.handle(command) ?: throw ApplicationException(String.format("No handler for %s", command.javaClass))
        } catch (e: Exception) {
            throw ApplicationException(String.format("Can't execute %s", command.name()), e)
        }
    }

    override fun <R> register(commandClass: Class<C>, commandHandler: CommandHandler<C, R>) {
        registry.putIfAbsent(commandClass, commandHandler)
    }
}