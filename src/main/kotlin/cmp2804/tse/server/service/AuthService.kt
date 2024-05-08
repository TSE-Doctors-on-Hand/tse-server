package cmp2804.tse.server.service

import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.dto.LoginDTO
import cmp2804.tse.server.dto.RegisterDTO
import cmp2804.tse.server.util.resposne.INVALID_PASSWORD_MESSAGE
import cmp2804.tse.server.util.resposne.SUCCESS_MESSAGE
import cmp2804.tse.server.util.resposne.USER_NOT_FOUND_MESSAGE
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Duration
import java.util.*

/**
 * Token name constant. This is applied when setting the token in the user's storage
 */
@Suppress("UastIncorrectHttpHeaderInspection") // Suppressed as we're making our own header
const val TOKEN_NAME = "Token"

/**
 * Authentication Service
 *
 * This service is responsible for user authorisation
 *
 * @author Oliver Whitehead
 * @author Ben Soones
 */
@Service
class AuthService(
    private val userService: UserService,
    private val patientService: PatientService
) {

    /**
     * Creates a user entity in the database and a user's token
     *
     * @return User token that's saved on the front end.
     * @see [RegisterDTO]
     */
    @Transactional
    fun register(registerDTO: RegisterDTO, response: HttpServletResponse): ResponseEntity<String> {
        val hashedPassword = BCryptPasswordEncoder().encode(registerDTO.password)

        val patient = patientService.createPatient(registerDTO, hashedPassword)
        val user = patient.user
        return ResponseEntity.ok(getToken(user))
    }

    /**
     * Login a user via their username and password
     *
     * @return User's token that's saved on the front end
     * @see [LoginDTO]
     */
    fun login(loginDTO: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user: User = userService.findByUsername(loginDTO.username)
            ?: return ResponseEntity.badRequest().body(USER_NOT_FOUND_MESSAGE)

        if (!user.comparePassword(loginDTO.password)) {
            return ResponseEntity.badRequest().body(INVALID_PASSWORD_MESSAGE)
        }

        return ResponseEntity.ok(getToken(user))
    }

    /**
     * Logs out a user by removing token from their local storage
     */
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        response.setHeader(TOKEN_NAME, "")
        return ResponseEntity.ok(SUCCESS_MESSAGE)
    }

    /**
     * Creates a token for a user
     *
     * @return A token with an expiration date of 24 hours from time of issue
     * @see [cmp2804.tse.server.util.auth.UserArgumentResolver]
     */
    private fun getToken(user: User): String {
        val issuer = user.id.toString()

        return Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + Duration.ofDays(1).toMillis())) // 24 hours
            .signWith(SignatureAlgorithm.HS512, "secret").compact()
    }

    /**
     * Retrieves a user by their token
     *
     * @return [User] if the token is valid
     * @see [cmp2804.tse.server.util.auth.UserArgumentResolver]
     */
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

    /**
     * Retrieves the user from a request
     *
     * @see getUser
     */
    fun getUserFromRequest(request: HttpServletRequest): User? {
        val token = request.getHeader("Token")
        return getUser(token)
    }


}