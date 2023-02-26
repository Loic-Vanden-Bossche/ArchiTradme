package esgi.al2.architradme.domain

import java.util.UUID

class ConsultantProfile {

    val id: UUID = UUID.randomUUID()
    var competences: List<String> = ArrayList()
    var tjm: Double = 0.0
    var disponibilities: List<String> = ArrayList()
    var modalities: String = ""

    public fun ConsultantProfile(competences: List<String>, tjm: Double, disponibilities: List<String>, modalities: String) {
        this.competences = competences
        this.tjm = tjm
        this.disponibilities = disponibilities
        this.modalities = modalities
    }

}