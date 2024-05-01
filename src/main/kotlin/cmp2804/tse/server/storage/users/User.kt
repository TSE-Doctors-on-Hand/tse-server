package cmp2804.tse.server.storage.users

import javax.persistence.*

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
    val username: String,

    /**
     * A hashed and salted password
     */
    val password: String,


    /**
     * A user's first name
     */
    val forename: String,

    /**
     * A user's last name
     */
    val surname: String,

    /**
     * A user's date of both
     */
    val dateOfBirth: Long,

    /**
     * A user's biological sex
     * This is their sex at birth, which is relevant for medical questions
     */
    val sex: SexEnum,

    /**
     * A list of pronouns for effective communication between
     * doctors and patients. The first pronoun will be the
     * preferred pronoun
     */
    @ElementCollection
    val pronouns: MutableList<String>,

    /**
     * A user's email address, this will be used to notify
     * them of updates to their application and communication
     * with their doctor
     */
    val email: String,

    /**
     * A user's phone number, for use as an emergency
     * form of contact by a doctor, if required
     */
    val phone: String?,

    /**
     * A user's default home location
     *
     * A Latitude and Longitude pair showing the GPS co-ordinates of the practice
     * This can be used with a maps API to get the location
     *
     * This will be the postal address for any physical forms of
     * communication
     */
    val homeLocationLat: Double,
    val homeLocationLong: Double,

    val nextOfKin: String
)