package esgi.al2.kernel

interface Command {
    fun name(): String {
        return this.javaClass.simpleName
    }
}