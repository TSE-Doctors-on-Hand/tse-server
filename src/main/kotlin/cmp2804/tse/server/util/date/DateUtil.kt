package cmp2804.tse.server.util.date

import java.sql.Date
import java.text.SimpleDateFormat

/**
 * Date converter from string to Date
 *
 * @see [Date]
 *
 * @author Oliver Whitehead
 */
object DateUtil {

    private val DATE_FORMAT = SimpleDateFormat("dd/MM/yyyy")

    /**
     * Returns a date object from a string
     */
    fun dateOrDefault(date: String, default: Date): Date {
        return parseDateString(date) ?: default
    }

    /**
     * Parses a string to date
     */
    private fun parseDateString(date: String): Date? {
        return try {
            val javaDate = DATE_FORMAT.parse(date)
            Date(javaDate.time)
        } catch (e: Throwable) {
            e.printStackTrace()
            null
        }
    }

}