
package esgi.al2.architradme.application.port.output;

import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId

interface UpdateConsultantPort {
    fun update(consultant: Consultant)
}