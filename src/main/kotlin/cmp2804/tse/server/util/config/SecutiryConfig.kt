package cmp2804.tse.server.util.config

import cmp2804.tse.server.service.TokenService
import com.nimbusds.jose.jwk.source.ImmutableSecret
import com.nimbusds.jose.proc.SecurityContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import javax.crypto.spec.SecretKeySpec

const val SECRET_KEY: String = "TODO"

@Configuration
@EnableWebSecurity
class SecurityConfig(
    @Value("\${security.key}")
    private val jwtKey: String,
    private val tokenService: TokenService
) {
    private val secretKey = SecretKeySpec(jwtKey.toByteArray(), "HmacSHA256")

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun jwtDecoder(): JwtDecoder {
        return NimbusJwtDecoder.withSecretKey(secretKey).build()
    }

    @Bean
    fun jwtEncoder(): JwtEncoder {
        val secret = ImmutableSecret<SecurityContext>(secretKey)
        return NimbusJwtEncoder(secret)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        // Define public and private routes
//        http.authorizeHttpRequests()
//            .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
//            .requestMatchers(HttpMethod.POST, "/api/register").permitAll()
//            .requestMatchers("/api/**").authenticated()
//            .anyRequest().permitAll() // In case you have a frontend
//
//        // Configure JWT
//        http.oauth2ResourceServer().jwt()
//        http.authenticationManager { auth ->
//            val jwt = auth as BearerTokenAuthenticationToken
//            val user = tokenService.parseToken(jwt.token) ?: throw InvalidBearerTokenException("Invalid token")
//            UsernamePasswordAuthenticationToken(user, "", listOf(SimpleGrantedAuthority("USER")))
//        }
//
//        // Other configuration
//        http.cors()
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        http.csrf().disable()
//        http.headers().frameOptions().disable()
//        http.headers().xssProtection().disable()
//
//        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        // allow localhost for dev purposes
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:3000", "http://localhost:8080")
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE")
        configuration.allowedHeaders = listOf("authorization", "content-type")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}