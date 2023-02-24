package esgi.al2.architradme;

import esgi.al2.architradme.application.port.input.ApiAliveQuery
import esgi.al2.architradme.application.services.ApiAliveService
import esgi.al2.kernel.QueryBus
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class StartupApplicationListener(
    queryBus: QueryBus<ApiAliveQuery>,
    apiAliveService: ApiAliveService
) :
    ApplicationListener<ContextRefreshedEvent?> {
    private val queryBus: QueryBus<ApiAliveQuery>
    private val apiAliveService: ApiAliveService


    init {
        this.queryBus = queryBus
        this.apiAliveService = apiAliveService
    }

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        queryBus.register(ApiAliveQuery::class.java, apiAliveService)
    }
}
