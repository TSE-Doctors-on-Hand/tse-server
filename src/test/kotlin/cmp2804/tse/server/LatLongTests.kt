package cmp2804.tse.server

import cmp2804.tse.server.util.LatLong
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LatLongTests {

    @Test
    fun `test is within range`() {
        val center = LatLong(30.539283555785502, 114.35080948660172)
        val outer = LatLong(30.569807958154993, 114.32678252255914) // Exactly 4km away
        val distance: Double = 5.0 // 5km

        val result = outer.isWithinRange(center, distance)
        val expected: Boolean = true

        assertEquals(expected, result, "The selected location is not within the range specified")
    }

    @Test
    fun `test is within range erroneous`() {
        val center = LatLong(30.539283555785502, 114.35080948660172)
        val outer = LatLong(30.569807958154993, 114.32678252255914) // Exactly 4km away
        val distance: Double = 1.0 // 5km

        val result = outer.isWithinRange(center, distance)
        val expected: Boolean = false

        assertEquals(expected, result, "The selected location is not within the range specified")
    }

    @Test
    fun `test haversine distance`() {
        val point1 = LatLong(30.539283555785502, 114.35080948660172)
        val point2 = LatLong(30.569807958154993, 114.32678252255914) // Exactly 4km away

        val result = point1.haversineDistance(point2)
        val expected: Double = 4.098179617366649

        assertEquals(expected, result, "The haversine calculation was incorrect $result")
    }

    @Test
    fun `test haversine distance erroneous`() {
        val point1 = LatLong(30.539283555785502, 114.35080948660172)
        val point2 = LatLong(30.569807958154993, 114.32678252255914) // Exactly 4km away

        val result = point1.haversineDistance(point2)
        val expected: Double = 10.202055

        assertNotEquals(expected, result, "The haversine calculation was incorrect $result")
    }

    @Test
    fun `test postcode from lat-long`() {
        val postcode = "RG2 8ED"

        val result = LatLong.fromPostcode(postcode)
        val expected = LatLong(51.42651129999999,-0.9432834999999999)

        assertEquals(expected, result, "The postcode conversion is invalid")
    }

    @Test
    fun `test postcode from lat-long erroneous`() {
        val postcode = "RG2 8ED"

        val result = LatLong.fromPostcode(postcode)
        val expected = LatLong(15.42651129999999,-18.9432835)

        assertNotEquals(expected, result, "The postcode conversion is invalid")
    }
}