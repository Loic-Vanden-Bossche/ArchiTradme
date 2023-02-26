package esgi.al2.kernel

interface QueryBus<Q : Query> {
    fun <R> post(query: Q): R
    fun <R> register(queryClass: Class<Q>, queryHandler: QueryHandler<Q, R>)
}