package cmp2804.tse.server.controller

import cmp2804.tse.server.service.AuthService
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.request.SignInRequest
import cmp2804.tse.server.util.request.SignUpRequest
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
    private val authService: AuthService
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
        signInRequest: SignInRequest
    ) {
    }

}