package esgi.al2.architradme.application.services

import esgi.al2.architradme.application.port.input.RegisterConsultantCommand
import esgi.al2.architradme.application.events.ConsultantRegisteredEvent
import esgi.al2.architradme.application.port.output.RegisterConsultantPort
import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId
import esgi.al2.kernel.CommandHandler
import esgi.al2.kernel.Event
import esgi.al2.kernel.EventDispatcher

class RegisterConsultantService(
    private val registerConsultantPort: RegisterConsultantPort,
    private val eventDispatcher: EventDispatcher<in Event>,
) : CommandHandler<RegisterConsultantCommand, String> {

    override fun handle(command: RegisterConsultantCommand): String {
        val consultantId: ConsultantId = registerConsultantPort.nextId()
        val consultant = Consultant(
            consultantId,
            command.firstName,
            command.lastName,
            command.email,
            command.skills,
            command.adr,
            command.availability,
            command.modalities
        )
        registerConsultantPort.register(consultant)
        eventDispatcher.dispatch(ConsultantRegisteredEvent(consultant.id, consultant.email))
        return consultantId.value()
    }
}