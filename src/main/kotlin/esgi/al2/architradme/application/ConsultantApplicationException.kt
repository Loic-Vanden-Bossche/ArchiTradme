package esgi.al2.architradme.application;

import esgi.al2.kernel.ApplicationException;
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ConsultantApplicationException private constructor(message: String) : ApplicationException(message) {
    companion object {
        fun notFound(id: String) = ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Consultant with id $id not found"
        )
    }
}
