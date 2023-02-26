package esgi.al2.architradme.application.port.input

import esgi.al2.kernel.Command
import jakarta.validation.constraints.NotNull

class RegisterConsultantCommand(
    @field:NotNull val firstName: String,
    @field:NotNull val lastName: String,
    @field:NotNull val email: String,
    @field:NotNull val skills: List<String>,
    @field:NotNull val adr: Double,
    val availability: String? = null,
    val modalities: String? = null
) : Command
