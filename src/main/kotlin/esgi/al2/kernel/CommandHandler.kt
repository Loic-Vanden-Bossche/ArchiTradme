package esgi.al2.kernel

interface CommandHandler<C : Command, R> {
    fun handle(command: C): R
}
