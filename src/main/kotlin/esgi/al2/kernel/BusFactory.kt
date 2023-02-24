package esgi.al2.kernel;

class BusFactory private constructor() {
    init {
        throw AssertionError()
    }

    companion object {

        fun defaultQueryBus(): QueryBus<Query> {
            return DefaultQueryBus(HashMap())
        }
    }
}

