package esgi.al2.architradme.application.port.input.events

import esgi.al2.architradme.domain.ConsultantId
import esgi.al2.kernel.Event

class ConsultantUpdatedEvent(
    private val consultantId: ConsultantId,
    private val email: String,
) : Event {

    fun getConsultantId(): ConsultantId {
        return consultantId
    }

    fun getEmail(): String {
        return email
    }
}