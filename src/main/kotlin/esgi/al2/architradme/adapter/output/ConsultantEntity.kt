package esgi.al2.architradme.adapter.output

import jakarta.persistence.*

@Entity
@Table(name = "T_CONSULTANT")
class ConsultantEntity() {
    constructor(
        id: String,
        firstName: String,
        lastName: String,
        email: String,
        skills: List<String>,
        adr: Double,
        availability: String?,
        modalities: String?
    ) : this() {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.skills = skills
        this.adr = adr
        this.availability = availability
        this.modalities = modalities
    }

    @Id
    var id: String = ""

    @Column(name = "first_name")
    var firstName: String = ""

    @Column(name = "last_name")
    var lastName: String = ""

    @Column(name = "email")
    var email: String = ""

    @ElementCollection
    @CollectionTable(name="T_CONSULTANT_SKILLS", joinColumns=[JoinColumn(name="consultant_id")])
    var skills: List<String> = mutableListOf()

    @Column(name = "adr")
    var adr: Double = 0.0

    @Column(name = "availability")
    var availability: String? = null

    @Column(name = "modalities")
    var modalities: String? = null
}