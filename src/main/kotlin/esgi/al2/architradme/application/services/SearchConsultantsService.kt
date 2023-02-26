package esgi.al2.architradme.application.services

import esgi.al2.architradme.application.port.input.SearchConsultantsQuery
import esgi.al2.architradme.application.port.output.SearchConsultantsPort
import esgi.al2.architradme.domain.Consultant
import esgi.al2.architradme.domain.ConsultantId
import esgi.al2.kernel.QueryHandler
import java.util.*

class SearchConsultantsService(
    private val searchConsultantsPort: SearchConsultantsPort,
) : QueryHandler<SearchConsultantsQuery, List<Consultant>> {

    override fun handle(query: SearchConsultantsQuery): List<Consultant> {
        val searchResults = searchConsultantsPort.search(query.skill, query.maxADR, query.minADR)

        return searchResults.map {
            Consultant(
                ConsultantId.of(UUID.fromString(it.id)),
                it.firstName,
                it.lastName,
                it.email,
                it.skills,
                it.adr,
                it.availability,
                it.modalities
            )
        }
    }
}