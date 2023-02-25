package esgi.al2.architradme.adapter.input

import esgi.al2.architradme.application.port.input.ApiAliveQuery
import esgi.al2.kernel.QueryBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/")
class ApiController {

    private var queryBus: QueryBus<ApiAliveQuery>? = null

    @Autowired
    private fun ApiController(queryBus: QueryBus<ApiAliveQuery>) {
        this.queryBus = queryBus
    }

    @GetMapping
    fun getAliveStatus(): ApiAliveResponse {
        val alive = this.queryBus?.post<Boolean>(ApiAliveQuery())
        return ApiAliveResponse(alive!!, UUID.randomUUID().toString())
    }
}