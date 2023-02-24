package esgi.al2.architradme;

import esgi.al2.architradme.application.services.ApiAliveService
import esgi.al2.kernel.KernelConfiguration
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(KernelConfiguration::class)
class ApplicationConfiguration {
    @Bean
    fun accountBalanceService(): ApiAliveService {
        return ApiAliveService()
    }
}
