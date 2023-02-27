package esgi.al2.architradme.application.services

import esgi.al2.architradme.application.ConsultantApplicationException
import esgi.al2.architradme.application.port.input.UpdateConsultantCommand
import esgi.al2.architradme.application.events.ConsultantUpdatedEvent
import esgi.al2.architradme.application.port.output.LoadConsultantPort
import esgi.al2.architradme.application.port.output.UpdateConsultantPort
import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId
import esgi.al2.kernel.CommandHandler
import esgi.al2.kernel.Event
import esgi.al2.kernel.EventDispatcher
import java.util.*

class UpdateConsultantService(
    private val updateConsultantPort: UpdateConsultantPort,
    private val loadConsultantPort: LoadConsultantPort,
    private val eventDispatcher: EventDispatcher<in Event>,
) : CommandHandler<UpdateConsultantCommand, String> {

    override fun handle(command: UpdateConsultantCommand): String {
        val consultantId = ConsultantId.of(UUID.fromString(command.consultantId))
        val consultantEntity = loadConsultantPort.load(consultantId)

        if (!consultantEntity?.isPresent!!) throw ConsultantApplicationException.notFound(command.consultantId)

        val consultant = Consultant(
            consultantId,
            command.firstName ?: consultantEntity.get().firstName,
            command.lastName ?: consultantEntity.get().lastName,
            consultantEntity.get().email,
            command.skills ?: consultantEntity.get().skills,
            command.adr ?: consultantEntity.get().adr,
            command.availability ?: consultantEntity.get().availability,
            command.modalities ?: consultantEntity.get().modalities
        )

        updateConsultantPort.update(consultant)
        eventDispatcher.dispatch(ConsultantUpdatedEvent(consultantId, "Consultant updated"))
        return consultantId.value()
    }
}