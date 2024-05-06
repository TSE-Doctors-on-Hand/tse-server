package cmp2804.tse.server.util.date

import java.sql.Date
import java.text.SimpleDateFormat

object DateUtil {

    val DATE_FORMAT = SimpleDateFormat("dd/MM/yyyy")

    fun dateOrDefault(date: String, default: Date): Date {
        return parseDateString(date) ?: default
    }

    // todo --> handling
    fun parseDateString(date: String): Date? {
        try {
            val javaDate = DATE_FORMAT.parse(date)
            return Date(javaDate.time)
        } catch (e: Throwable) {
            e.printStackTrace()
            return null
        }
    }

}