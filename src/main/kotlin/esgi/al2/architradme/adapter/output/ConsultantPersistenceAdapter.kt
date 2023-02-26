package esgi.al2.architradme.adapter.output

import esgi.al2.architradme.application.port.output.RegisterConsultantPort
import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId
import java.util.*

class ConsultantPersistenceAdapter(
    private var consultantEntityRepository: ConsultantEntityRepository?
) : RegisterConsultantPort {

    override fun nextId(): ConsultantId {
        return ConsultantId.of(UUID.randomUUID())
    }

    override fun register(consultant: Consultant) {
        for (skill in consultant.skills) {
            println(skill)
        }

        val consultantEntity = ConsultantEntity(
            consultant.id.value(),
            consultant.firstName,
            consultant.lastName,
            consultant.email,
            consultant.skills,
            consultant.adr,
            consultant.availability,
            consultant.modalities
        )

        consultantEntityRepository?.save(consultantEntity)
    }
}