package cmp2804.tse.server.dto

/**
 * Data Transfer Object to send login info
 **
 * @property username
 * @property password
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
data class LoginDTO(
    val username: String,
    val password: String
)