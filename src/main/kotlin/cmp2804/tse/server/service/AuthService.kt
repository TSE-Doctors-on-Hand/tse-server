package cmp2804.tse.server.service

import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.request.SignUpRequest
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
}