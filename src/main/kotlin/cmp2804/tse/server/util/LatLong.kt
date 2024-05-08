package cmp2804.tse.server.util

import cmp2804.tse.server.util.matcher.CartesianPoint
import cmp2804.tse.server.util.matcher.dotProduct
import com.nimbusds.jose.shaded.gson.JsonParser
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory
import java.lang.NullPointerException
import kotlin.math.*

/**
 * Google Maps API address to retrieve the latitude and longitude from a postcode
 *
 * @see <a href="https://developers.google.com/maps/documentation">Source</a>
 */
private const val API_ADDRESS = "https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s"

/**
 * API key for above API
 *
 * **NOTE: For examination purposes, please use this API key**
 */
private const val GOOGLE_MAPS_API_KEY = "AIzaSyAy_xu3NevkXxJVqgKztP5u1B3qmctYaHY"

/**
 * Calculated average of Earth's radius from its height and width (since it's a spheroid)
 *
 * @see <a href="https://imagine.gsfc.nasa.gov/features/cosmic/earth_info.html#:~:text=Note%3A%20The%20Earth%20is%20almost,the%20polar%20and%20equatorial%20values">Source</a>
 */
const val EARTH_RADIUS_KM = 6367.5

/**
 * Lambda function to calculate the angular distance from a given distance
 *
 * @see <a href="https://encyclopedia.pub/entry/32854">Source</a>
 */
private val getAngularRadius: (Double) -> Double = { distance ->
    distance / EARTH_RADIUS_KM
}

/**
 * Represents the latitude and longitude of a point on Earth
 *
 * @property latitude
 * @property longitude
 *
 * @author Ben Soones
 */
data class LatLong(
    val latitude: Double,
    val longitude: Double
) {

    /**
     * Checks whether the object's location is within a range of a centre point
     *
     * This calculates the angular radius via a dot product of geospatial coordinates and checks
     * if it is greater than the threshold (angular radius of distance)
     *
     * @param center[LatLong] The point of origin, as a LatLong
     * @param distance[Double] The distance in km
     * @return Boolean of whether the object's location is within range of the center
     *
     * @see <a href="https://www.mit.edu/~hlb/StantonGrant/18.02/details/tex/lec1snip2-dotprod.pdf">Source</a>
     */
    fun isWithinRange(center: LatLong, distance: Double): Boolean {
        val cartesianCenter = CartesianPoint.fromLatLong(center)
        val cartesianPoint = CartesianPoint.fromLatLong(this)

        val dotProduct = dotProduct(cartesianCenter, cartesianPoint) / (EARTH_RADIUS_KM.pow(2))

        return dotProduct >= cos(getAngularRadius(distance))
    }

    /**
     * Calculates the distance between the current location and a given LatLong via the Haversine formula
     *
     * @param other The LatLong to compare to
     * @return Distance between the two points in km
     *
     * @see <a href="https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/">Source</a>
     */
    fun haversineDistance(other: LatLong): Double {
        val lat1 = Math.toRadians(latitude)
        val lon1 = Math.toRadians(longitude)
        val lat2 = Math.toRadians(other.latitude)
        val lon2 = Math.toRadians(other.longitude)

        val dLat = lat2 - lat1
        val dLon = lon2 - lon1

        val a = sin(dLat / 2).pow(2) + cos(lat1) * cos(lat2) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return EARTH_RADIUS_KM * c
    }

    companion object {
        private val logger = LoggerFactory.getLogger("LatLong")

        /**
         * Retrieves the LatLong of a postcode via the Google Maps API and a OkHttpClient request
         *
         * @param postcode A compatible postcode
         * @return LatLong object
         * @return LatLong of 0,0 on error
         *
         * @see <a href="https://square.github.io/okhttp/">Docs</a>
         */
        fun fromPostcode(postcode: String): LatLong {

            val client = OkHttpClient()
            val request = Request.Builder()
                .url(
                    API_ADDRESS.format(postcode, GOOGLE_MAPS_API_KEY)
                )
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    logger.error("Unsuccessful response for postcode: $postcode")
                    return LatLong(0.0, 0.0)
                }

                try {
                    val json = JsonParser.parseString(response.body?.string())
                    val results = json.asJsonObject["results"].asJsonArray

                    if (results.size() == 0) {
                        logger.error("Invalid response for postcode: $postcode")
                        return LatLong(0.0, 0.0)
                    }
                    val location = results[0].asJsonObject["geometry"].asJsonObject["location"].asJsonObject

                    return LatLong(
                        location["lat"]?.asDouble ?: 0.0,
                        location["lng"]?.asDouble ?: 0.0,
                    )
                } catch (e: NullPointerException) {
                    logger.error("Null pointer for lat/long data for $postcode")
                    return LatLong(0.0, 0.0)
                }
            }

        }
    }
}