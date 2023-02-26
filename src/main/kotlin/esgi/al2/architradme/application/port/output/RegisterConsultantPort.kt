
package esgi.al2.architradme.application.port.output;

import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId

interface RegisterConsultantPort {
    fun nextId(): ConsultantId
    fun register(consultant: Consultant)
}