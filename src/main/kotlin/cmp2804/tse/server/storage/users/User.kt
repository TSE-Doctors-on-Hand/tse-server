package cmp2804.tse.server.storage.users

import cmp2804.tse.server.storage.roles.Role
import cmp2804.tse.server.storage.base.validators.phone.Phone
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import jakarta.persistence.*
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import org.hibernate.validator.constraints.Length
import java.sql.Date

const val USER_TABLE_NAME = "users"

/**
 * **User table**
 *
 * Stores all information about a user
 *
 * @author Ben Soones
 */
@Entity
@Table(name = USER_TABLE_NAME)
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, length = 50)
    @Length(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @NotNull(message = "Username cannot be null")
    var username: String,

    /**
     * A hashed and salted password
     */
    @NotNull(message = "Password cannot be null")
    var password: String,

    /**
     * A user's first name
     */
    @Column(length = 50)
    @Length(min = 2, max = 50, message = "Forename must be between 2 and 50 characters")
    @NotNull(message = "Forename cannot be null")
    var forename: String,

    /**
     * A user's last name
     */
    @Column(length = 50)
    @Length(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    @NotNull(message = "Surname cannot be null")
    var surname: String,

    /**
     * A user's date of both
     */

    @Past(message = "Date of birth must be in the past")
    @NotNull(message = "Date of birth cannot be null")
    var dateOfBirth: Date,

    /**
     * A user's biological sex
     * This is their sex at birth, which is relevant for medical questions
     */
    @NotNull(message = "Sex cannot be null")
    var sex: SexEnum,

    /**
     * A list of pronouns for effective communication between
     * doctors and patients. The first pronoun will be the
     * preferred pronoun
     */
    @ElementCollection
    @NotNull(message = "Pronouns cannot be null")
    var pronouns: MutableList<@Length(max = 17) String>,

    /**
     * A user's email address, this will be used to notify
     * them of updates to their application and communication
     * with their doctor
     */
    @Email(message = "Must be a valid email")
    @NotNull(message = "Email cannot be null")
    var email: String,

    /**
     * A user's phone number, for use as an emergency
     * form of contact by a doctor, if required
     */
    @Phone(message = "Must be a valid phone number")
    var phone: String?,

    /**
     * A user's default home location
     *
     * A Latitude and Longitude pair showing the GPS co-ordinates of the practice
     * This can be used with a maps API to get the location
     *
     * This will be the postal address for any physical forms of
     * communication
     */
    @DecimalMin("-90.00", message = "Location must be valid")
    @DecimalMax("90.00", message = "Location must be valid")
    @NotNull(message = "Location cannot be null")
    var homeLocationLat: Double,

    @DecimalMin("-180.00", message = "Location must be valid")
    @DecimalMax("180.00", message = "Location must be valid")
    @NotNull(message = "Location cannot be null")
    var homeLocationLong: Double,

    var nextOfKin: String,

    @ManyToMany(mappedBy = "users", cascade = [CascadeType.ALL])
    @NotNull(message = "Roles cannot be null")
    var roles: Set<Role>

) {
    constructor() : this(
        null,
        "",
        "",
        "",
        "",
        Date(2000,1,1),
        SexEnum.MALE,
        mutableListOf(),
        "",
        "",
        0.00,
        0.00,
        "",
        setOf(),
    )

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }

    fun getHighestRole(): Role? {
        return this.roles.maxByOrNull { it.name.ordinal }
    }
}