package cmp2804.tse.server.util.matcher

import cmp2804.tse.server.util.EARTH_RADIUS_KM
import cmp2804.tse.server.util.LatLong
import kotlin.math.cos
import kotlin.math.sin

data class CartesianPoint(
    val x: Double,
    val y: Double,
    val z: Double
) {
    companion object {
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

fun dotProduct(
    point1: CartesianPoint,
    point2: CartesianPoint
): Double {
    return point1.x * point2.x +
            point1.y * point2.y +
            point1.z * point2.z
}