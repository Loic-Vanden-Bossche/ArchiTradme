package esgi.al2.architradme.application.services

import esgi.al2.architradme.application.events.ConsultantUpdatedEvent
import esgi.al2.architradme.application.port.output.Notifications
import esgi.al2.kernel.EventHandler

class ConsultantUpdatedEventHandler(
    private val notifications: Notifications
) : EventHandler<ConsultantUpdatedEvent> {

    override fun handle(event: ConsultantUpdatedEvent) {
        notifications.notify(
            String.format(
                "Notification of the consultant update with id %s and email %s",
                event.getConsultantId().value(),
                event.getEmail()
            )
        )
    }
}