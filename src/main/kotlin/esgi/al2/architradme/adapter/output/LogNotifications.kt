package esgi.al2.architradme.adapter.output

import esgi.al2.architradme.application.port.output.Notifications

class LogNotifications : Notifications {
    override fun notify(message: String) {
        println(message)
    }
}