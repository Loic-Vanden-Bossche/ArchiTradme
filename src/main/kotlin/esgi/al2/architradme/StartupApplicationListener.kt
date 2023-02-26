package esgi.al2.architradme

import esgi.al2.architradme.adapter.input.ConsultantController
import esgi.al2.architradme.application.port.input.ApiAliveQuery
import esgi.al2.architradme.application.services.ApiAliveService
import esgi.al2.kernel.*
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class StartupApplicationListener(
    queryBus: QueryBus<Query>,
    commandBus: CommandBus<Command>,
    eventDispatcher: EventDispatcher<Event>,
    apiAliveService: ApiAliveService
) :
    ApplicationListener<ContextRefreshedEvent?> {
    private val queryBus: QueryBus<Query>
    private val commandBus: CommandBus<Command>

    private val eventDispatcher: EventDispatcher<Event>

    private val apiAliveService: ApiAliveService


    init {
        this.queryBus = queryBus
        this.commandBus = commandBus

        this.eventDispatcher = eventDispatcher

        this.apiAliveService = apiAliveService
    }

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        queryBus.register(
            ApiAliveQuery::class.java as Class<Query>,
            apiAliveService as QueryHandler<Query, *>
        )
    }
}
