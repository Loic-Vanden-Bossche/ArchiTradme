package esgi.al2.architradme.application.port.input

import esgi.al2.kernel.Command
import jakarta.validation.constraints.NotNull

class UpdateConsultantCommand(
    @field:NotNull val consultantId: String,
    val firstName: String?,
    val lastName: String?,
    val skills: List<String>?,
    val adr: Double?,
    val availability: String?,
    val modalities: String?
) : Command
