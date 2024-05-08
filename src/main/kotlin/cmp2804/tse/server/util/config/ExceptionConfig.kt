package cmp2804.tse.server.util.config

import cmp2804.tse.server.util.error.GlobalExceptionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Configuration to allow for custom error handling
 *
 * @see [GlobalExceptionHandler]
 * @author Ben Soones
 */
@Configuration
class ExceptionConfig {
    @Bean
    fun globalExceptionHandler(): GlobalExceptionHandler = GlobalExceptionHandler()

}