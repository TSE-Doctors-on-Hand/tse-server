package cmp2804.tse.server.storage.users

import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.roles.ROLE_TABLE_NAME
import cmp2804.tse.server.storage.roles.Role
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import jakarta.persistence.*

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

    @Column(unique = true)
    var username: String,

    /**
     * A hashed and salted password
     */
    var password: String,


    /**
     * A user's first name
     */
    var forename: String,

    /**
     * A user's last name
     */
    var surname: String,

    /**
     * A user's date of both
     */
    var dateOfBirth: Long,

    /**
     * A user's biological sex
     * This is their sex at birth, which is relevant for medical questions
     */
    var sex: SexEnum,

    /**
     * A list of pronouns for effective communication between
     * doctors and patients. The first pronoun will be the
     * preferred pronoun
     */
    @ElementCollection
    var pronouns: MutableList<String>,

    /**
     * A user's email address, this will be used to notify
     * them of updates to their application and communication
     * with their doctor
     */
    var email: String,

    /**
     * A user's phone number, for use as an emergency
     * form of contact by a doctor, if required
     */
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
    var homeLocationLat: Double,
    var homeLocationLong: Double,

    var nextOfKin: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    var roles: Set<Role>

) {

//    @ManyToOne
//    @JoinColumn(name = "id")
//    lateinit var carer: Patient

    constructor(): this(
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