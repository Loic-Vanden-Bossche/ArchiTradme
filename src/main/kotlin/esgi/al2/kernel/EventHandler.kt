package esgi.al2.kernel

interface EventHandler<E : Event> {
    fun handle(event: E)
}
