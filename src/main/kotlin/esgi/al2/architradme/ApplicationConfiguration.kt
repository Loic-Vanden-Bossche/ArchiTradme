package esgi.al2.architradme

import esgi.al2.architradme.adapter.output.ConsultantEntityRepository
import esgi.al2.architradme.adapter.output.ConsultantPersistenceAdapter
import esgi.al2.architradme.adapter.output.LogNotifications
import esgi.al2.architradme.application.services.ApiAliveService
import esgi.al2.architradme.application.services.ConsultantRegisteredEventHandler
import esgi.al2.architradme.application.services.RegisterConsultantService
import esgi.al2.kernel.Event
import esgi.al2.kernel.EventDispatcher
import esgi.al2.kernel.KernelConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(KernelConfiguration::class)
class ApplicationConfiguration {

    @Autowired
    private val consultantEntityRepository: ConsultantEntityRepository? = null

    @Autowired
    private val eventDispatcher: EventDispatcher<Event>? = null

    @Bean
    fun apiAliveService(): ApiAliveService {
        return ApiAliveService()
    }

    @Bean
    fun registerConsultantService(): RegisterConsultantService {
        return RegisterConsultantService(
            persistenceAdapter(),
            eventDispatcher!!
        )
    }

    @Bean
    fun persistenceAdapter(): ConsultantPersistenceAdapter {
        return ConsultantPersistenceAdapter(consultantEntityRepository)
    }

    @Bean
    fun notifications(): LogNotifications {
        return LogNotifications()
    }

    @Bean
    fun accountCreatedEventHandler(): ConsultantRegisteredEventHandler {
        return ConsultantRegisteredEventHandler(notifications())
    }

}
