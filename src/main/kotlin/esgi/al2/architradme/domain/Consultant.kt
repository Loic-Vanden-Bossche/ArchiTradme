package esgi.al2.architradme.domain

import java.util.*
import kotlin.collections.ArrayList

class Consultant {

    var id: ConsultantId = ConsultantId.of(UUID.randomUUID())

    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""

    var skills: List<String> = ArrayList()
    var adr: Double = 0.0
    var availability: List<String> = ArrayList()
    var modalities: String = ""

    constructor(
        id: ConsultantId,
        firstName: String,
        lastName: String,
        email: String,
        skills: List<String>,
        adr: Double,
        availability: List<String>,
        modalities: String
    ) {
        this.id = id

        this.firstName = firstName
        this.lastName = lastName
        this.email = email

        this.skills = skills
        this.adr = adr
        this.availability = availability
        this.modalities = modalities
    }

}