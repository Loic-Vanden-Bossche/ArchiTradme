package esgi.al2.architradme.domain

class Consultant(
    var id: ConsultantId,
    var firstName: String,
    var lastName: String,
    var email: String,
    var skills: List<String>,
    var adr: Double,
    var availability: String?,
    var modalities: String?
)