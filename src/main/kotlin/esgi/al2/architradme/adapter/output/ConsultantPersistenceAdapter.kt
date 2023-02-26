package esgi.al2.architradme.adapter.output

import esgi.al2.architradme.application.port.output.LoadConsultantPort
import esgi.al2.architradme.application.port.output.RegisterConsultantPort
import esgi.al2.architradme.application.port.output.SearchConsultantsPort
import esgi.al2.architradme.application.port.output.UpdateConsultantPort
import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId
import java.util.*

class ConsultantPersistenceAdapter(
    private var consultantEntityRepository: ConsultantEntityRepository?
) : RegisterConsultantPort, UpdateConsultantPort, LoadConsultantPort, SearchConsultantsPort {

    override fun nextId(): ConsultantId {
        return ConsultantId.of(UUID.randomUUID())
    }

    override fun register(consultant: Consultant) {
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

    override fun update(consultant: Consultant) {
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

    override fun load(consultantId: ConsultantId): Optional<ConsultantEntity>? {
        return consultantEntityRepository?.findById(consultantId.value())
    }

    override fun search(
        skill: String?,
        maxADR: Double?,
        minADR: Double?,
    ): List<ConsultantEntity> {
        return consultantEntityRepository?.search(skill, maxADR, minADR) ?: emptyList()
    }
}