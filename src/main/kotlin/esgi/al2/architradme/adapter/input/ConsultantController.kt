package esgi.al2.architradme.adapter.input

import esgi.al2.architradme.application.port.input.RegisterConsultantCommand
import esgi.al2.kernel.Command
import esgi.al2.kernel.CommandBus
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/consultants")
class ConsultantController(
    private val commandBus: CommandBus<Command>,
    //private val queryBus: QueryBus<Query>
) {

    @PostMapping(value = ["/register"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    private fun register(
        @RequestBody @Valid registerConsultantRequest: RegisterConsultantRequest
    ): RegisterConsultantResponse {
        val accountId = commandBus.post<String>(RegisterConsultantCommand(
            registerConsultantRequest.firstName,
            registerConsultantRequest.lastName,
            registerConsultantRequest.email,
            registerConsultantRequest.skills,
            registerConsultantRequest.adr,
            registerConsultantRequest.availability,
            registerConsultantRequest.modalities
        ))
        return RegisterConsultantResponse(accountId)
    }

}