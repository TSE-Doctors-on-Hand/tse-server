package cmp2804.tse.server.dto

/**
 * Data Transfer Object to send login info
 **
 * @property username
 * @property password
 * @property forename User's forename
 * @property surname User's surname
 * @property dateOfBirth User's date of birth in DD/MM/YYYY format
 * @property sex User's [cmp2804.tse.server.storage.users.SexEnum] ordinal
 * @property pronouns List of user's pronouns
 * @property email User email
 * @property phone User UK phone number
 * @property postcode User's postcode
 * @property nextOfKin User's next of kin information
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
data class RegisterDTO(
    val username: String,
    val password: String,
    val forename: String,
    val surname: String,
    val dateOfBirth: String,
    val sex: Int,
    val pronouns: MutableList<String>,
    val email: String,
    val phone: String?,
    val postcode: String,
    val nextOfKin: String
    ) {}