package cmp2804.tse.server.util.matcher

import cmp2804.tse.server.storage.doctors.Doctor

data class MatchedDoctor(
    val doctor: Doctor,
    val similarity: Double, // This is a percentage -> 0.95 = 95%
    val distance: Double // Distance in km from the patient
)
