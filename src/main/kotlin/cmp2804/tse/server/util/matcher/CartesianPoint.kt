package cmp2804.tse.server.util.matcher

import cmp2804.tse.server.util.EARTH_RADIUS_KM
import cmp2804.tse.server.util.LatLong
import kotlin.math.cos
import kotlin.math.sin

/**
 * Represents a 3D Cartesian point on a spheroid (The Earth)
 *
 * @author Ben Soones
 */
data class CartesianPoint(
    val x: Double,
    val y: Double,
    val z: Double
) {
    companion object {

        /**
         * Calculating a cartesian point from a LatLong via spherical-to-Cartesian-transformation
         *
         * @see <a href="https://www.movable-type.co.uk/scripts/latlong.html">Source</a>
         */
        fun fromLatLong(latLong: LatLong): CartesianPoint {
            val latRad = Math.toRadians(latLong.latitude)
            val longRad = Math.toRadians(latLong.longitude)

            return CartesianPoint(
                x = EARTH_RADIUS_KM * cos(latRad) * cos(longRad),
                y = EARTH_RADIUS_KM * cos(latRad) * sin(longRad),
                z = EARTH_RADIUS_KM * sin(latRad)
            )
        }
    }

}

/**
 * Calculates the dot product of two cartesian points
 */
fun dotProduct(
    point1: CartesianPoint,
    point2: CartesianPoint
): Double {
    return point1.x * point2.x +
            point1.y * point2.y +
            point1.z * point2.z
}