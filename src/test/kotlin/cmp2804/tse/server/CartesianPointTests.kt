package cmp2804.tse.server

import cmp2804.tse.server.util.LatLong
import cmp2804.tse.server.util.matcher.CartesianPoint
import cmp2804.tse.server.util.matcher.dotProduct
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CartesianPointTests {

    @Test
    fun `test is from lat long`() {

        val latLong = LatLong(30.539283555785502, 114.35080948660172)

        val result = CartesianPoint.fromLatLong(latLong)
        val expected = CartesianPoint(
            -2261.261356652736,
            4996.320571347833,
            3235.5114086084595
        )

        assertEquals(expected, result, "Cartesian point calculation is incorrect: $result")
    }

    @Test
    fun `test is from lat long erroneous`() {

        val latLong = LatLong(30.539283555785502, 114.35080948660172)

        val result = CartesianPoint.fromLatLong(latLong)
        val expected = CartesianPoint(
            -4335.261356652736,
            6343.320571347833,
            353.5114086084595
        )

        assertNotEquals(expected, result, "Cartesian point calculation is incorrect when it shouldn't be: $result")
    }

    @Test
    fun `test dot product`() {

        val point1 = CartesianPoint(100.0, 100.0, 100.0)
        val point2 = CartesianPoint(200.0, 200.0, 200.0)

        val result = dotProduct(point1, point2)
        val expected: Double = 60000.0

        assertEquals(expected, result, "Dot product calculation is incorrect: $result")
    }

    @Test
    fun `test dot product erroneous`() {

        val point1 = CartesianPoint(100.0, 100.0, 100.0)
        val point2 = CartesianPoint(200.0, 200.0, 200.0)

        val result = dotProduct(point1, point2)
        val expected: Double = 0.0

        assertNotEquals(expected, result, "Dot product calculation is incorrect: $result")
    }

}