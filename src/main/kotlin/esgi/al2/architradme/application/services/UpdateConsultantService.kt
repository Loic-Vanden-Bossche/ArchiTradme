package esgi.al2.architradme.application.services

import esgi.al2.architradme.application.port.input.UpdateConsultantCommand
import esgi.al2.architradme.application.port.input.events.ConsultantUpdatedEvent
import esgi.al2.architradme.application.port.output.UpdateConsultantPort
import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId
import esgi.al2.kernel.CommandHandler
import esgi.al2.kernel.Event
import esgi.al2.kernel.EventDispatcher

class UpdateConsultantService(
    private val updateConsultantPort: UpdateConsultantPort,
    private val eventDispatcher: EventDispatcher<in Event>,
) : CommandHandler<UpdateConsultantCommand, String> {

    override fun handle(command: UpdateConsultantCommand): String {
        val consultantId: ConsultantId = updateConsultantPort.nextId()
        val consultant = Consultant(
            consultantId,
            command.firstName,
            command.lastName,
            "command.email",
            command.skills,
            command.adr,
            command.availability,
            command.modalities
        )
        updateConsultantPort.update(consultant)
        eventDispatcher.dispatch(ConsultantUpdatedEvent(consultant.id, consultant.email))
        return consultantId.value()
    }
}