package esgi.al2.architradme.application.services;

import esgi.al2.architradme.application.port.input.ApiAliveQuery
import esgi.al2.kernel.QueryHandler

class ApiAliveService : QueryHandler<ApiAliveQuery, Boolean> {
    override fun handle(query: ApiAliveQuery): Boolean {
        return true
    }
}
