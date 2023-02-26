package esgi.al2.architradme.application.services

import esgi.al2.architradme.application.port.input.events.ConsultantRegisteredEvent
import esgi.al2.architradme.application.port.output.Notifications
import esgi.al2.kernel.EventHandler

class ConsultantRegisteredEventHandler(
    private val notifications: Notifications
) : EventHandler<ConsultantRegisteredEvent> {

    override fun handle(event: ConsultantRegisteredEvent) {
        notifications.notify(
            String.format(
                "Notification of the consultant registration with id %s and email %s",
                event.getConsultantId(),
                event.getEmail()
            )
        )
    }
}