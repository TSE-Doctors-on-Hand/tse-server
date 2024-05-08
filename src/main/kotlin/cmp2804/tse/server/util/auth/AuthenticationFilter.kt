package cmp2804.tse.server.util.auth

import cmp2804.tse.server.service.AuthService
import jakarta.servlet.*
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component

/**
 * **CORS (Cross-Origin Resource Sharing) filter**
 *
 * This filter is responsible for authorisation checks, as well as
 * managing protected endpoints
 *
 * @see [UserArgumentResolver]
 *
 * @author Oliver Whitehead
 * @author Ben Soones
 *
 */
@Component
class AuthenticationFilter(private val authService: AuthService) : Filter {

    /**
     * List of all endpoints that require a user to be logged in to
     * in order to access
     */
    private val PROTECTED_ENDPOINTS = listOf(
        "/api/appointment/",
        "/api/doctor/",
        "/api/user/"
    )

    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        chain: FilterChain
    ) {

        if (request is HttpServletRequest) {
            val token = request.getHeader("Token")
            val user = authService.getUser(token)

            val isProtectedEndpoint = PROTECTED_ENDPOINTS.any { endpoint ->
                request.requestURI.startsWith(endpoint)
            }

            if (isProtectedEndpoint) {
                if (user != null) {
                    // Attach user information to the request
                    request.setAttribute("user", user)
                } else {
                    (response as HttpServletResponse).status = HttpServletResponse.SC_UNAUTHORIZED
                    response.writer.write("Unauthorised")
                    return
                }
            }
        }
        chain.doFilter(request, response)
    }

    override fun init(filterConfig: FilterConfig?) {}

    override fun destroy() {}
}