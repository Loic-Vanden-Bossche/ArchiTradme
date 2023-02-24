package esgi.al2.kernel;

interface QueryHandler<Q : Query, out R> {
    fun handle(query: Q): R
}