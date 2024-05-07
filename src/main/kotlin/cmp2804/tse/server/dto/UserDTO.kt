package cmp2804.tse.server.dto

import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.LatLong
import java.sql.Date

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
