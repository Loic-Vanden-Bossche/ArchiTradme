package esgi.al2.architradme.application.port.input

import esgi.al2.kernel.Query

data class SearchConsultantsQuery(
    val skill: String?,
    val maxADR: Double?,
    val minADR: Double?,
) : Query