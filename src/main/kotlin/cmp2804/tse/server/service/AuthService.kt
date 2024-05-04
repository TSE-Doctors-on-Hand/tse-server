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
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

const val TOKEN_COOKIE_NAME = "token"

@Service
class AuthService(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun signUp(signUpRequest: SignUpRequest): ResponseEntity<User> {
        val hashedPassword = passwordEncoder.encode(signUpRequest.password)

        val user = userService.createUser(signUpRequest, hashedPassword)
        return ResponseEntity.ok(user)
    }

    fun signIn(signInRequest: SignInRequest, response: HttpServletResponse): ResponseEntity<Any> {
        val user: User = userService.findByUsername(signInRequest.username)
            ?: return ResponseEntity.badRequest().body(USER_NOT_FOUND_MESSAGE)

        if (!user.comparePassword(signInRequest.password)) {
            return ResponseEntity.badRequest().body(INVALID_PASSWORD_MESSAGE)
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 24 hours
            .signWith(SignatureAlgorithm.ES512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        return ResponseEntity.ok(SUCCESS_MESSAGE)
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

}