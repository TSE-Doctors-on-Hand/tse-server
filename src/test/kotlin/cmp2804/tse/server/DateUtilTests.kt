@file:Suppress("DEPRECATION")

package cmp2804.tse.server

import cmp2804.tse.server.util.date.DateUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.springframework.boot.test.context.SpringBootTest
import java.sql.Date

@SpringBootTest
class DateUtilTests {

    @Test
    fun `test date conversion`() {
        val dateStr = "01/01/2000"

        val result = DateUtil.dateOrDefault(dateStr, Date(2021,5,5))
        val expected: Date = Date(100,0,1)

        assertEquals(expected, result, "DateUtil does not correctly parse a date - $result")
    }

    @Test
    fun `test date conversion erroneous`() {
        val dateStr = "01/01/2000"

        val result = DateUtil.dateOrDefault(dateStr, Date(2021,5,5))
        // Ensuring correct date is set
        val expected: Date = Date(2000,0,1)

        assertNotEquals(expected, result, "DateUtil does not correctly parse a date - $result")
    }

}