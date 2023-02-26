package esgi.al2.architradme.application.port.input

import esgi.al2.kernel.Command
import jakarta.validation.constraints.NotNull

class RegisterConsultantCommand(
    @field:NotNull val skills: List<String>,
) : Command
