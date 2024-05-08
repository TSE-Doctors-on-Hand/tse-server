package cmp2804.tse.server.util.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

/**
 * An extra filter chain to prevent preflight request from being filtered by
 * the CORS mapping
 *
 * @see [cmp2804.tse.server.util.auth.AuthenticationFilter]
 *
 * @author Oliver Whitehead
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.cors(Customizer.withDefaults())
            .authorizeHttpRequests {
                it.anyRequest().permitAll()
            }.csrf { it.disable() }
        return http.build()

    }

}