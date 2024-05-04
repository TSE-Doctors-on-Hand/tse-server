package cmp2804.tse.server.storage.practices

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.util.LatLong
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
    @Length(max = 1000)
    @NotNull
    val name: String,

    /**
     * Practice Location
     *
     * A Latitude and Longitude pair showing the GPS co-ordinates of the practice
     * This can be used with a maps API to get the location
     */
    @DecimalMin("-90.00")
    @DecimalMax("90.00")
    @NotNull
    val locationLat: Double,

    @DecimalMin("-180.00")
    @DecimalMax("180.00")
    @NotNull
    val locationLong: Double,

    /**
     * Practice address
     *
     * A text address, showing postcodes, street names, etc. for a user to view
     */
    @NotNull
    val address: String,

    @ManyToMany
    @JoinColumn(name = "doctor_id")
    @NotNull
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
}