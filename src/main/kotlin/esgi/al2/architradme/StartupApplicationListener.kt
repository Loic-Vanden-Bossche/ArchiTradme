package esgi.al2.architradme

import esgi.al2.architradme.application.port.input.ApiAliveQuery
import esgi.al2.architradme.application.port.input.RegisterConsultantCommand
import esgi.al2.architradme.application.port.input.UpdateConsultantCommand
import esgi.al2.architradme.application.port.input.events.ConsultantRegisteredEvent
import esgi.al2.architradme.application.port.input.events.ConsultantUpdatedEvent
import esgi.al2.architradme.application.services.*
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
    private val updateConsultantService: UpdateConsultantService,
    private val consultantRegisteredEventHandler: ConsultantRegisteredEventHandler,
    private val consultantUpdatedEventHandler: ConsultantUpdatedEventHandler,
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

        commandBus.register(
            UpdateConsultantCommand::class.java as Class<Command>,
            updateConsultantService as CommandHandler<Command, *>
        )

        eventDispatcher.register(
            ConsultantRegisteredEvent::class.java as Class<Event>,
            consultantRegisteredEventHandler as EventHandler<Event>
        )

        eventDispatcher.register(
            ConsultantUpdatedEvent::class.java as Class<Event>,
            consultantUpdatedEventHandler as EventHandler<Event>
        )
    }
}
