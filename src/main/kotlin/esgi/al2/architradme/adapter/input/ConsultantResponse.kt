package esgi.al2.architradme.adapter.input

import esgi.al2.architradme.domain.Consultant

data class ConsultantResponse(private val consultant: Consultant) {
    var id: String = consultant.id.value()
    var firstName: String = consultant.firstName
    var lastName: String = consultant.lastName
    var email: String = consultant.email
    var skills: List<String> = consultant.skills
    var adr: Double = consultant.adr
    var availability: String? = consultant.availability
    var modalities: String? = consultant.modalities
}