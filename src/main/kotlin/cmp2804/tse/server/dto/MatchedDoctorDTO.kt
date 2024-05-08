package cmp2804.tse.server.dto

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.practices.Practice

/**
 * Data Transfer Object to send matched doctor info
 *
 * @param forename Doctor forename
 * @param surname Doctor surname
 * @param aboutMe Doctor's about me
 * @param email Doctor's email address
 * @param phone Doctor's phone number
 * @param specialties A list of doctor's speciality names
 * @param practiceName The closest practice name
 * @param practiceAddress The closest practice address
 * @param similarity The similarity score
 * @param distance The distance in KM
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
data class MatchedDoctorDTO(
    val forename: String,
    val surname: String,
    val aboutMe: String,
    val email: String,
    val phone: String,
    val specialties: List<String>,
    val practiceName: String,
    val practiceAddress: String,
    val similarity: Double,
    val distance: Double
) {

    companion object {

        /**
         * Creates a [MatchedDoctorDTO]
         *
         * @param doctor
         * @param practice
         * @param similarity
         * @param distance
         */
        fun fromDoctor(doctor: Doctor, practice: Practice, similarity: Double, distance: Double): MatchedDoctorDTO {
            return MatchedDoctorDTO(
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
