package cmp2804.tse.server.util

import kotlin.math.*

// https://imagine.gsfc.nasa.gov/features/cosmic/earth_info.html#:~:text=Note%3A%20The%20Earth%20is%20almost,the%20polar%20and%20equatorial%20values.
// Average of both values to make perfect sphere
// TODO -> Reference properly
private const val EARTH_RADIUS_KM = 6367.5

data class LatLong(
    val latitude: Double,
    val longitude: Double
) {

    fun isInRange(latLong: Pair<Double, Double>, distance: Double): Boolean {
        return isInRange(latLong.first, latLong.second, distance)
    }

    fun isInRange(lat: Double, long: Double, distance: Double): Boolean {
        return (haversineDistance(Pair(lat,long)) <= distance)
    }

    // https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/
    // TODO -> Reference properly
    // TODO -> Explain why using pair for other values
    private fun haversineDistance(point2: Pair<Double, Double>): Double {
        val lat1 = Math.toRadians(latitude)
        val lon1 = Math.toRadians(longitude)
        val lat2 = Math.toRadians(point2.first)
        val lon2 = Math.toRadians(point2.second)

        val dLat = lat2 - lat1
        val dLon = lon2 - lon1

        val a = sin(dLat / 2).pow(2) + cos(lat1) * cos(lat2) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return EARTH_RADIUS_KM * c
    }
}