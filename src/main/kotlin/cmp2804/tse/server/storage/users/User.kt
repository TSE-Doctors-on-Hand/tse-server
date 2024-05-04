package cmp2804.tse.server.storage.users

import cmp2804.tse.server.storage.roles.Role
import cmp2804.tse.server.storage.validators.pasttimestamp.PastTimestamp
import cmp2804.tse.server.storage.validators.phone.Phone
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import jakarta.persistence.*
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length

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
    @Length(min = 3, max = 50)
    @NotNull
    var username: String,

    /**
     * A hashed and salted password
     */
    @NotNull
    var password: String,

    /**
     * A user's first name
     */
    @Column(length = 50)
    @Length(min = 2, max = 50)
    @NotNull
    var forename: String,

    /**
     * A user's last name
     */
    @Column(length = 50)
    @Length(min = 2, max = 50)
    @NotNull
    var surname: String,

    /**
     * A user's date of both
     */
    @PastTimestamp
    @NotNull
    var dateOfBirth: Long,

    /**
     * A user's biological sex
     * This is their sex at birth, which is relevant for medical questions
     */
    @NotNull
    var sex: SexEnum,

    /**
     * A list of pronouns for effective communication between
     * doctors and patients. The first pronoun will be the
     * preferred pronoun
     */
    @ElementCollection
    @NotNull
    var pronouns: MutableList<@Length(max = 17) String>,

    /**
     * A user's email address, this will be used to notify
     * them of updates to their application and communication
     * with their doctor
     */
    @Email
    @NotNull
    var email: String,

    /**
     * A user's phone number, for use as an emergency
     * form of contact by a doctor, if required
     */
    @Phone
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
    @DecimalMin("-90.00")
    @DecimalMax("90.00")
    @NotNull
    var homeLocationLat: Double,

    @DecimalMin("-180.00")
    @DecimalMax("180.00")
    @NotNull
    var homeLocationLong: Double,

    var nextOfKin: String,

    @ManyToMany(mappedBy = "users", cascade = [CascadeType.ALL])
    @NotNull
    var roles: Set<Role>

) {
    constructor() : this(
        null,
        "",
        "",
        "",
        "",
        0L,
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