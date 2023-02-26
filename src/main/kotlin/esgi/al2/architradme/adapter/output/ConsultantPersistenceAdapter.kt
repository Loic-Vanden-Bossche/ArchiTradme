package esgi.al2.architradme.adapter.output

import esgi.al2.architradme.domain.ConsultantId
import java.util.*

class ConsultantPersistenceAdapter(private var consultantEntityRepository: ConsultantEntityRepository?) {

    fun nextId(): ConsultantId {
        return ConsultantId.of(UUID.randomUUID())
    }
}