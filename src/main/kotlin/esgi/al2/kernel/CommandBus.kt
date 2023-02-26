package esgi.al2.kernel

interface CommandBus<C : Command> {
    fun <R> post(command: C): R
    fun <R> register(commandClass: Class<C>, commandHandler: CommandHandler<C, R>)
}
