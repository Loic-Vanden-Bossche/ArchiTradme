
package esgi.al2.architradme.application.port.output;

import esgi.al2.architradme.adapter.output.ConsultantEntity
import esgi.al2.architradme.domain.ConsultantId
import java.util.*

interface LoadConsultantPort {
    fun load(consultantId: ConsultantId): Optional<ConsultantEntity>?
}