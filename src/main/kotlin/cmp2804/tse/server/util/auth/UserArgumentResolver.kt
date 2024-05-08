package cmp2804.tse.server.util.auth

import cmp2804.tse.server.service.AuthService
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.error.errors.UnauthorisedException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

/**
 * User argument resolved
 *
 * When a "user" argument is added to a function, this retrieves the user from
 * the request, and adds it in:
 *
 * **Example:**
 * ```kotlin
 * @GetMapping("/test")
 * fun getTest(user: User): ResponseEntity<String> {
 *     return ResponseEntity.ok(user.username)
 * }
 * ```
 * In this example, the user object is "injected" into the function via a token lookup
 *
 * @see [User]
 * @see [AuthService.getUser]
 *
 * @author Oliver Whitehead
 * @author Ben Soones
 */
@Component
class UserArgumentResolver(
    private val authService: AuthService
) : HandlerMethodArgumentResolver {

    /**
     * Checks the function to see if a user is required
     */
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.parameterType == User::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any {
        try {
            val request = webRequest.getNativeRequest(HttpServletRequest::class.java)

            val user = request?.let { authService.getUserFromRequest(it) }

            if(user == null) {
                throw UnauthorisedException()
            }

            request.setAttribute("user", user)
            return user
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            throw UnauthorisedException()
        }
    }
}