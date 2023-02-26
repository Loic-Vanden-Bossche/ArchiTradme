package esgi.al2.architradme.adapter.output

import jakarta.persistence.*

@Entity
@Table(name = "T_CONSULTANT")
class ConsultantEntity() {
    constructor(id: String, competences: List<String>) : this() {
        this.id = id
        this.competences = competences
    }

    @Id
    var id: String? = null

    @ElementCollection
    @CollectionTable(name="T_CONSULTANT_COMPETENCES", joinColumns=[JoinColumn(name="consultant_id")])
    var competences: List<String>? = null
}