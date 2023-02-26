package esgi.al2.architradme.adapter.input

import jakarta.validation.constraints.NotNull

class RegisterConsultantRequest(
    @field:NotNull val firstName: String,
    @field:NotNull val lastName: String,
    @field:NotNull val email: String,
    @field:NotNull val skills: List<String>,
    @field:NotNull val adr: String,
    val disponibility: String? = null
)