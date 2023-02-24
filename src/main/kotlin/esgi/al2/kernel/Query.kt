package esgi.al2.kernel;

interface Query {
    fun name() = this::class.simpleName
}