package esgi.al2.architradme.adapter.output

import jakarta.persistence.*

@Entity
@Table(name = "T_CONSULTANT")
class ConsultantEntity() {
    constructor(id: String, skills: List<String>) : this() {
        this.id = id
        this.skills = skills
    }

    @Id
    var id: String? = null

    @ElementCollection
    @CollectionTable(name="T_CONSULTANT_SKILLS", joinColumns=[JoinColumn(name="consultant_id")])
    var skills: List<String>? = null
}