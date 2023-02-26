package esgi.al2.kernel

class DefaultEventDispatcher<E : Event>(
    private val register: MutableMap<Class<E>, EventHandler<E>>
) : EventDispatcher<E> {
    override fun dispatch(event: E) {
        val eventHandler = register[event.javaClass]
            ?: throw ApplicationException(String.format("No handler for the event %s", event.name()))
        eventHandler.handle(event)
    }

    override fun register(eventClass: Class<E>, handler: EventHandler<E>) {
        register[eventClass] = handler
    }

    companion object {
        fun create(): DefaultEventDispatcher<Event> {
            return DefaultEventDispatcher(mutableMapOf())
        }
    }
}
