package cmp2804.tse.server.dto

data class DoctorSearchDTO(
    val postcode: String?,
    val range: Int,
    val symptoms: Set<Long>,
    val limit: Int
)