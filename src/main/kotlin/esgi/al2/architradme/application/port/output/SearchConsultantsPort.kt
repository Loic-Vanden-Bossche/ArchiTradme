
package esgi.al2.architradme.application.port.output;

import esgi.al2.architradme.adapter.output.ConsultantEntity

interface SearchConsultantsPort {
    fun search(
        skill: String?,
        maxADR: Double?,
        minADR: Double?,
    ): List<ConsultantEntity>
}