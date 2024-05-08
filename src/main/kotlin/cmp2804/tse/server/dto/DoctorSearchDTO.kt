package cmp2804.tse.server.dto

import cmp2804.tse.server.service.MATCHING_DOCTOR_LIMIT

/**
 * Data Transfer Object to send doctor search requests
 **
 * @property postcode Postcode for centre point. Null for user's default
 * @property range Search range in km
 * @property symptoms List of Symptom IDs
 * @property limit Max number of results to show (default [MATCHING_DOCTOR_LIMIT])
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
data class DoctorSearchDTO(
    val postcode: String?,
    val range: Int,
    val symptoms: Set<Long>,
    val limit: Int = MATCHING_DOCTOR_LIMIT
)