package esgi.al2.architradme.adapter.input

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiAliveController {

    @GetMapping
    fun getAliveStatus(): String {
        return "API is alive"
    }
}