package cmp2804.tse.server.controller.base

import cmp2804.tse.server.service.AuthService
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.request.SignInRequest
import cmp2804.tse.server.util.request.SignUpRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
@Validated
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/register")
    fun postSignUp(
        @RequestBody
        signUpRequest: SignUpRequest,
        response: HttpServletResponse
    ): ResponseEntity<String> {
        try {
            return authService.signUp(signUpRequest, response)
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
        throw Exception("Failed to sign up")
    }

    @PostMapping("/login")
    fun postSignIn(
        @RequestBody
        signInRequest: SignInRequest,
        response: HttpServletResponse
    ): ResponseEntity<Any> {
        return authService.signIn(signInRequest, response)
    }

    @PostMapping("/logout")
    fun postSignOut(
        response: HttpServletResponse
    ): ResponseEntity<Any> {
        return authService.signOut(response)
    }

}