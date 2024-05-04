package cmp2804.tse.server.controller

import cmp2804.tse.server.service.AuthService
import cmp2804.tse.server.service.UserService
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.request.SignInRequest
import cmp2804.tse.server.util.request.SignUpRequest
import cmp2804.tse.server.util.resposne.INVALID_PASSWORD_MESSAGE
import cmp2804.tse.server.util.resposne.SUCCESS_MESSAGE
import cmp2804.tse.server.util.resposne.USER_NOT_FOUND_MESSAGE
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/auth")
@Validated
class AuthController(
    private val authService: AuthService,
    private val userService: UserService
) {

    @PostMapping("/signup")
    fun postSignUp(
        @RequestBody
        signUpRequest: SignUpRequest
    ): ResponseEntity<User> {
        return authService.signUp(signUpRequest)
    }

    @PostMapping("/signin")
    fun postSignIn(
        @RequestBody
        signInRequest: SignInRequest,
        response: HttpServletResponse
    ): ResponseEntity<Any> {
        return authService.signIn(signInRequest, response)
    }

}