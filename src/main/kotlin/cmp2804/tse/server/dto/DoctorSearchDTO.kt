package cmp2804.tse.server.dto

data class DoctorSearchDTO(
    val postcode: String?,
    val range: Int,
    val symptomIds: Set<Long>,
    val limit: Int

)