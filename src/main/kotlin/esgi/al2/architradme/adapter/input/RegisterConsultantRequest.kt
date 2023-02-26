package esgi.al2.architradme.adapter.input

import jakarta.validation.constraints.NotNull

class RegisterConsultantRequest {
    @NotNull
    val firstName: String? = null

    @NotNull
    val lastName: String? = null

    @NotNull
    val email: String? = null

    @NotNull
    val password: String? = null

    @NotNull
    val skills: List<String>? = null

    @NotNull
    val adr: String? = null

    val disponibility: String? = null
}