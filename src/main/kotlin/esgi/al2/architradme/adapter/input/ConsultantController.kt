package esgi.al2.architradme.adapter.input

import esgi.al2.kernel.Command
import esgi.al2.kernel.CommandBus
import esgi.al2.kernel.Query
import esgi.al2.kernel.QueryBus
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/consultants")
class ConsultantController {
    private var commandBus: CommandBus<Command>? = null
    private var queryBus: QueryBus<Query>? = null

    @Autowired
    private fun ConsultantController(
        commandBus: CommandBus<Command>,
        queryBus: QueryBus<Query>
    ) {
        this.commandBus = commandBus
        this.queryBus = queryBus
    }

    @PostMapping(value = ["/register"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    private fun register(
        @RequestBody @Valid transferAccountRequest: RegisterConsultantRequest
    ): RegisterConsultantResponse {
        // commandBus?.post()
        return RegisterConsultantResponse("test")
    }

}