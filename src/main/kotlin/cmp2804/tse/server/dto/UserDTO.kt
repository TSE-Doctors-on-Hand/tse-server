package cmp2804.tse.server.dto

import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.LatLong
import java.sql.Date

/**
 * Data Transfer Object to send login info
 **
 * @property id User ID
 * @property username
 * @property forename User's forename
 * @property surname User's surname
 * @property dateOfBirth User's date of birth as a [Date]
 * @property sex [SexEnum] ordinal
 * @property pronouns List of user's pronouns
 * @property email User's email
 * @property phone User's UK phone
 * @property postcode User's home postcode
 * @property nextOfKin Next of kin information for user
 * @property roles User's roles
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
data class UserDTO(
    val id: Long?,
    val username: String,
    val forename: String,
    val surname: String,
    val dateOfBirth: Date,
    val sex: Int,
    val pronouns: MutableList<String>,
    val email: String,
    val phone: String?,
    val postcode: String,
    val nextOfKin: String,
    val roles: MutableSet<RolesEnum>
) {

    companion object {

        /**
         * Converts a [User] object to a [UserDTO]
         */
        fun fromUser(user: User): UserDTO {
            val sexEnum = user.sex.ordinal

            return UserDTO(
                id = user.id,
                username = user.username,
                forename = user.forename,
                surname = user.surname,
                dateOfBirth = user.dateOfBirth,
                sex = sexEnum,
                pronouns = user.pronouns,
                email = user.email,
                phone = user.phone,
                postcode = user.postcode ?: "Unknown",
                nextOfKin = user.nextOfKin,
                roles = user.roles,
            )
        }
    }


}
