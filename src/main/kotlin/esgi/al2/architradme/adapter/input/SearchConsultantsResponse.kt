package esgi.al2.architradme.adapter.input

import esgi.al2.architradme.domain.Consultant

data class SearchConsultantsResponse(private val consultantsInput: List<Consultant>) {
    var consultants =  consultantsInput.map { ConsultantResponse(it) }
}