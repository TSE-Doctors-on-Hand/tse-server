package cmp2804.tse.server.storage.practices

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.util.LatLong
import jakarta.persistence.*

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
    val name: String,

    /**
     * Practice Location
     *
     * A Latitude and Longitude pair showing the GPS co-ordinates of the practice
     * This can be used with a maps API to get the location
     */
    val locationLat: Double,
    val locationLong: Double,

    /**
     * Practice address
     *
     * A text address, showing postcodes, street names, etc. for a user to view
     */
    val address: String,

) {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    lateinit var doctor: Doctor

    constructor() : this(
        null,
        "",
        0.0,
        0.0,
        "",
    )

    fun latLong(): LatLong = LatLong(locationLat, locationLong)
}