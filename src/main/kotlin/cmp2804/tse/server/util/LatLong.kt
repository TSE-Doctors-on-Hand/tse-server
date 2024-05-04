package cmp2804.tse.server.util

import cmp2804.tse.server.util.matcher.CartesianPoint
import cmp2804.tse.server.util.matcher.dotProduct
import kotlin.math.*

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

    fun isInRange(latLong: Pair<Double, Double>, distance: Double): Boolean {
        return isInRange(latLong.first, latLong.second, distance)
    }

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
}