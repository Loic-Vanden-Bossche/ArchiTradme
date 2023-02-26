package esgi.al2.architradme.adapter.input

import esgi.al2.architradme.application.port.input.RegisterConsultantCommand
import esgi.al2.architradme.application.port.input.SearchConsultantsQuery
import esgi.al2.architradme.application.port.input.UpdateConsultantCommand
import esgi.al2.architradme.domain.Consultant
import esgi.al2.kernel.*
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/consultants")
class ConsultantController(
    private val commandBus: CommandBus<Command>,
    private val queryBus: QueryBus<Query>
) {

    @GetMapping(value = ["search"], produces = [MediaType.APPLICATION_JSON_VALUE])
    private fun search(
        @RequestParam skill: String?,
        @RequestParam maxADR: Double?,
        @RequestParam minADR: Double?,
    ): SearchConsultantsResponse {
        val consultants = queryBus.post<List<Consultant>>(SearchConsultantsQuery(skill, maxADR, minADR))
        return SearchConsultantsResponse(consultants)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
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

    @PutMapping(value = ["{consultantId}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    private fun update(
        @RequestBody @Valid updateConsultantRequest: UpdateConsultantRequest, @PathVariable consultantId: String
    ): UpdateConsultantResponse {

        if (!IsUUIDValidator().isValid(consultantId)) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST, "consultantId is not a valid UUID"
            )
        }

        val accountId = commandBus.post<String>(UpdateConsultantCommand(
            consultantId,
            updateConsultantRequest.firstName,
            updateConsultantRequest.lastName,
            updateConsultantRequest.skills,
            updateConsultantRequest.adr,
            updateConsultantRequest.availability,
            updateConsultantRequest.modalities
        ))
        return UpdateConsultantResponse(accountId)
    }

}