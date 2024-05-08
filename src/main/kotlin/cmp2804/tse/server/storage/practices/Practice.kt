package cmp2804.tse.server.storage.practices

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.util.LatLong
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length

const val PRACTICE_TABLE_NAME = "practices"

/**
 * **Practices table**
 *
 * Stores all information about a practice
 *
 * @author Ben Soones
 */
@Entity
@Table(name = PRACTICE_TABLE_NAME)
data class Practice(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    /**
     * Practice name
     *
     * This will appear on the search list
     */
    @Column(length = 1000)
    @Length(max = 1000, message = "Practice name must be less than 1,000 chars")
    @NotNull(message = "Practice name cannot be null")
    val name: String,

    /**
     * Practice Location
     *
     * Latitude and Longitude showing the GPS co-ordinates of the practice
     * This is created from a user's Postcode
     */
    @DecimalMin("-90.00", message = "Location must be valid")
    @DecimalMax("90.00", message = "Location must be valid")
    @NotNull(message = "Location cannot be null")
    val locationLat: Double,

    @DecimalMin("-180.00", message = "Location must be valid")
    @DecimalMax("180.00", message = "Location must be valid")
    @NotNull(message = "Location cannot be null")
    val locationLong: Double,

    /**
     * Practice address
     *
     * A text address, showing postcodes, street names, etc. for a user to view
     */
    @NotNull(message = "Address cannot be null")
    val address: String,

    /**
     * Practice doctors
     *
     * A set of all doctors that practice at this practice
     */
    @ManyToMany(mappedBy = "practices")
    @NotNull(message = "Doctors cannot be null")
    @JsonBackReference
    var doctors: Set<@Valid Doctor>,

) {
    constructor() : this(
        null,
        "",
        0.0,
        0.0,
        "",
        setOf()
    )

    fun latLong(): LatLong = LatLong(locationLat, locationLong)

    // Override funcs to prevent stack overflow error
    override fun hashCode(): Int {
        return id?.toInt()!!
    }

    override fun toString(): String {
        return ""
    }

}