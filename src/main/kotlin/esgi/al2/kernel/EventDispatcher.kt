package esgi.al2.kernel

interface EventDispatcher<E : Event> {
    fun dispatch(event: E)
    fun register(eventClass: Class<E>, handler: EventHandler<E>)
}
