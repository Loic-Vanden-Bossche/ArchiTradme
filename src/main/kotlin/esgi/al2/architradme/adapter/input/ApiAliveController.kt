package esgi.al2.architradme.adapter.input

import esgi.al2.architradme.application.port.input.ApiAliveQuery
import esgi.al2.kernel.QueryBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ApiAliveController {

    private var queryBus: QueryBus<ApiAliveQuery>? = null

    @Autowired
    private fun ApiAliveController(queryBus: QueryBus<ApiAliveQuery>) {
        this.queryBus = queryBus
    }

    @GetMapping
    fun getAliveStatus(): ApiAliveResponse {
        val alive = this.queryBus?.post<Boolean>(ApiAliveQuery())
        return ApiAliveResponse(alive!!)
    }
}