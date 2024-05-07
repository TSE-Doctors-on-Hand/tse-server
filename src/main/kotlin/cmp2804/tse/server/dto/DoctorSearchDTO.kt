package cmp2804.tse.server.dto

import cmp2804.tse.server.service.MATCHING_DOCTOR_LIMIT

data class DoctorSearchDTO(
    val postcode: String?,
    val range: Int,
    val symptoms: Set<Long>,
    val limit: Int? = MATCHING_DOCTOR_LIMIT
)