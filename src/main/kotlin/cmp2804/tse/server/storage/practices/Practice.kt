package cmp2804.tse.server.storage.practices

import javax.persistence.*

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
    @GeneratedValue
    val id: Long,

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
    val locationLong: Double
) {
    constructor() : this(0, "", 0.00, 0.00)
}