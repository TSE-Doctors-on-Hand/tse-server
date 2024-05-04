package cmp2804.tse.server.util.auth

import cmp2804.tse.server.service.AuthService
import cmp2804.tse.server.service.TOKEN_COOKIE_NAME
import jakarta.servlet.*
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component

@Component
class AuthenticationFilter(private val authService: AuthService) : Filter {
    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        chain: FilterChain
    ) {
        if (request is HttpServletRequest) {
            val token = request.cookies?.firstOrNull { it.name == TOKEN_COOKIE_NAME }?.value
            val user = authService.getUser(token)

            if (user != null) {
                // Attach user information to the request
                request.setAttribute("user", user)
            } else {
                (response as HttpServletResponse).status = HttpServletResponse.SC_UNAUTHORIZED
                response.writer.write("Unauthorised")
                return
            }
        }
        chain.doFilter(request, response) // Continue the filter chain
    }

    override fun init(filterConfig: FilterConfig?) {}

    override fun destroy() {}
}