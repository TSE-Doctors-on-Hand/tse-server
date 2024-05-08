package cmp2804.tse.server.util

import cmp2804.tse.server.util.matcher.CartesianPoint
import cmp2804.tse.server.util.matcher.dotProduct
import com.nimbusds.jose.shaded.gson.JsonParser
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.NullPointerException
import kotlin.math.*

private val API_ADDRESS = "https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s"
private const val GOOGLE_MAPS_API_KEY = "AIzaSyAy_xu3NevkXxJVqgKztP5u1B3qmctYaHY"

// https://imagine.gsfc.nasa.gov/features/cosmic/earth_info.html#:~:text=Note%3A%20The%20Earth%20is%20almost,the%20polar%20and%20equatorial%20values.
// Average of both values to make perfect sphere
// TODO -> Reference properly
const val EARTH_RADIUS_KM = 6367.5
private val getAngularRadius: (Double) -> Double = { distance ->
    distance / EARTH_RADIUS_KM
}

data class LatLong(
    val latitude: Double,
    val longitude: Double
) {

    fun isWithinRange(center: LatLong, distance: Double): Boolean {
        val cartesianCenter = CartesianPoint.fromLatLong(center)
        val cartesianPoint = CartesianPoint.fromLatLong(this)

        val dotProduct = dotProduct(cartesianCenter, cartesianPoint) / (EARTH_RADIUS_KM.pow(2))

        return dotProduct >= cos(getAngularRadius(distance))
    }


    // https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/
    // TODO -> Reference properly
    // TODO -> Explain why using pair for other values
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
        fun fromPostcode(postcode: String): LatLong {

            val client = OkHttpClient()
            val request = Request.Builder()
                .url(
                    API_ADDRESS.format(postcode, GOOGLE_MAPS_API_KEY)
                )
                .build()

            // TODO -> Code cleanup
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    // TODO -> Logging
                    return LatLong(0.0, 0.0)
                }

                try {
                    val json = JsonParser.parseString(response.body?.string())
                    val results = json.asJsonObject["results"].asJsonArray

                    if (results.size() == 0) {
                        // TODO -> Logging
                        return LatLong(0.0, 0.0)
                    }
                    val location = results[0].asJsonObject["geometry"].asJsonObject["location"].asJsonObject

                    return LatLong(
                        location["lat"]?.asDouble ?: 0.0,
                        location["lng"]?.asDouble ?: 0.0,
                    )
                } catch (e: NullPointerException) {
                    // TODO -> Logging
                    return LatLong(0.0, 0.0)
                }
            }

        }
    }
}