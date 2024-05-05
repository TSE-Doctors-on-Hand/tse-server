package cmp2804.tse.server.service

import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.request.SignInRequest
import cmp2804.tse.server.util.request.SignUpRequest
import cmp2804.tse.server.util.resposne.INVALID_PASSWORD_MESSAGE
import cmp2804.tse.server.util.resposne.SUCCESS_MESSAGE
import cmp2804.tse.server.util.resposne.UNAUTHORIZED_MESSAGE
import cmp2804.tse.server.util.resposne.USER_NOT_FOUND_MESSAGE
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Duration
import java.util.*

const val TOKEN_COOKIE_NAME = "token"

@Service
class AuthService(
    private val userService: UserService,
    private val patientService: PatientService
) {
    @Transactional
    fun signUp(signUpRequest: SignUpRequest,  response: HttpServletResponse): ResponseEntity<User> {
        val hashedPassword = BCryptPasswordEncoder().encode(signUpRequest.password)

        val patient = patientService.createPatient(signUpRequest, hashedPassword)
        val user = patient.user
        setTokenResponse(user, response)
        return ResponseEntity.ok(patient.user)
    }

    fun signIn(signInRequest: SignInRequest, response: HttpServletResponse): ResponseEntity<Any> {
        val user: User = userService.findByUsername(signInRequest.username)
            ?: return ResponseEntity.badRequest().body(USER_NOT_FOUND_MESSAGE)

        if (!user.comparePassword(signInRequest.password)) {
            return ResponseEntity.badRequest().body(INVALID_PASSWORD_MESSAGE)
        }

        setTokenResponse(user, response)

        return ResponseEntity.ok(SUCCESS_MESSAGE)
    }

    fun signOut(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie(TOKEN_COOKIE_NAME, "")
        cookie.maxAge = 0
        response.addCookie(cookie)

        return ResponseEntity.ok(SUCCESS_MESSAGE)
    }

    private fun setTokenResponse(user: User, response: HttpServletResponse) {
        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + Duration.ofDays(1).toMillis())) // 24 hours
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie(TOKEN_COOKIE_NAME, jwt)
        response.addCookie(cookie)
    }

    fun getUser(token: String?): User? {
        try {
            if (token == null) {
                return null
            }
            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).body
            return userService.findById(body.issuer.toLong())
        } catch (e: Exception) {
            return null
        }
    }

    fun getUserFromRequest(request: HttpServletRequest): User? {
        if (request.cookies == null) return null
        val token = request.cookies.find { it.name == TOKEN_COOKIE_NAME }?.value ?: return null
        return getUser(token)
    }


}