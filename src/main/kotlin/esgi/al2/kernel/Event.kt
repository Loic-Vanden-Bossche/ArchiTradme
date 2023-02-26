package esgi.al2.kernel

interface Event {
    fun name(): String {
        return javaClass.simpleName
    }
}
