package esgi.al2.architradme.adapter.input

data class UpdateConsultantRequest(
    val firstName: String?,
    val lastName: String?,
    val skills: List<String>?,
    val adr: Double?,
    val availability: String?,
    val modalities: String?
)