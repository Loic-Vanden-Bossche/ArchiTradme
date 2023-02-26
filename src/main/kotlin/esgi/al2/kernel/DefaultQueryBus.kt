package esgi.al2.kernel

import jakarta.validation.Validator


internal class DefaultQueryBus<Q : Query>(
    registry: MutableMap<Class<Q>, QueryHandler<Q, *>>,
    validator: Validator
) : QueryBus<Q> {
    private val registry: MutableMap<Class<Q>, QueryHandler<Q, *>>
    private val validator: Validator

    init {
        this.registry = registry
        this.validator = validator
    }

    override fun <R> post(query: Q): R {
        val violations = validator.validate(query)
        if (violations.isNotEmpty()) {
            throw RuntimeException(violations.toString())
        }

        return try {
            val queryHandler: QueryHandler<Q, R> = registry[query.javaClass] as QueryHandler<Q, R>
            queryHandler.handle(query)
        } catch (e: Exception) {
            throw ApplicationException(String.format("Can't execute %s", query.name()), e)
        }
    }

    override fun <R> register(queryClass: Class<Q>, queryHandler: QueryHandler<Q, R>) {
        registry.putIfAbsent(queryClass, queryHandler)
    }
}
