package cmp2804.tse.server.controller.base

import cmp2804.tse.server.service.AuthService
import cmp2804.tse.server.dto.LoginDTO
import cmp2804.tse.server.dto.RegisterDTO
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Controller for all auth purposes
 *
 * **This controller has the following endpoints:**
 *
 *  - /register: This post request registers a user via a [RegisterDTO]. This also adds their token to their
 *  session storage
 *
 *  - /login: This post request logs in a user via a [LoginDTO]. This also adds their token to their session storage
 *
 *  - /logout: This post request logs out a user by clearing their token from their session storage
 *
 * @property authService Auth service
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@RestController
@RequestMapping("/api/auth")
@Validated
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/register")
    fun postRegister(
        @RequestBody
        registerDTO: RegisterDTO,
        response: HttpServletResponse
    ): ResponseEntity<String> {
        try {
            return authService.register(registerDTO, response)
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
        throw Exception("Failed to sign up")
    }

    @PostMapping("/login")
    fun postLogin(
        @RequestBody
        loginDTO: LoginDTO,
        response: HttpServletResponse
    ): ResponseEntity<Any> {
        return authService.login(loginDTO, response)
    }

    @PostMapping("/logout")
    fun postLogout(
        response: HttpServletResponse
    ): ResponseEntity<Any> {
        return authService.logout(response)
    }

}