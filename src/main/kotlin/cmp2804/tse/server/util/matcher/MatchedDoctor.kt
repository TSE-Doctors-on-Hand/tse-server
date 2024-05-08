package cmp2804.tse.server.util.matcher

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.practices.Practice

data class MatchedDoctor(
    val forename: String,
    val surname: String,
    val aboutMe: String,
    val email: String,
    val phone: String,
    val specialties: List<String>,
    val practiceName: String,
    val practiceAddress: String,
    val similarity: Double,
    val distance: Double // Distance in km from the patient
) {

    companion object {
        fun fromDoctor(doctor: Doctor, practice: Practice, similarity: Double, distance: Double): MatchedDoctor {
            return MatchedDoctor(
                forename = doctor.user.forename,
                surname = doctor.user.surname,
                aboutMe = doctor.aboutMe,
                email = doctor.user.email,
                phone = doctor.user.phone ?: "Unknown",
                specialties = doctor.specialties.map { it.name },
                practiceName = practice.name,
                practiceAddress = practice.address,
                similarity = similarity,
                distance = distance,
            )
        }
    }
}
