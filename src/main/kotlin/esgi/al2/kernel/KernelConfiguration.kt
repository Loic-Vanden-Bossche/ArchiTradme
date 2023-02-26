package esgi.al2.kernel;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KernelConfiguration {
    @Bean
    fun queryBus(): QueryBus<*> {
        return BusFactory.defaultQueryBus()
    }

    @Bean
    fun commandBus(): CommandBus<*> {
        return BusFactory.defaultCommandBus()
    }
}
