package esgi.al2.architradme

import esgi.al2.architradme.application.port.input.ApiAliveQuery
import esgi.al2.architradme.application.port.input.RegisterConsultantCommand
import esgi.al2.architradme.application.port.input.events.ConsultantRegisteredEvent
import esgi.al2.architradme.application.services.ApiAliveService
import esgi.al2.architradme.application.services.ConsultantRegisteredEventHandler
import esgi.al2.architradme.application.services.RegisterConsultantService
import esgi.al2.kernel.*
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class StartupApplicationListener(
    private val queryBus: QueryBus<Query>,
    private val commandBus: CommandBus<Command>,
    private val eventDispatcher: EventDispatcher<Event>,
    private val apiAliveService: ApiAliveService,
    private val registerConsultantService: RegisterConsultantService,
    private val consultantRegisteredEventHandler: ConsultantRegisteredEventHandler,
) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        queryBus.register(
            ApiAliveQuery::class.java as Class<Query>,
            apiAliveService as QueryHandler<Query, *>
        )

        commandBus.register(
            RegisterConsultantCommand::class.java as Class<Command>,
            registerConsultantService as CommandHandler<Command, *>
        )

        eventDispatcher.register(
            ConsultantRegisteredEvent::class.java as Class<Event>,
            consultantRegisteredEventHandler as EventHandler<Event>
        )
    }
}
