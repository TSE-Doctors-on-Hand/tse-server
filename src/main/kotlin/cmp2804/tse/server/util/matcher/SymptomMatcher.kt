package cmp2804.tse.server.util.matcher

import cmp2804.tse.server.dto.MatchedDoctorDTO
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.util.LatLong

/**
 * Symptom matcher
 *
 * This is responsible for all symptom matching
 *
 * @see [Doctor]
 * @see [MatchedDoctorDTO]
 *
 * @author Ben Soones
 */
object SymptomMatcher {

    /**
     * Convert a list of [Doctor] via symptoms, and a LatLong
     *
     * @return List of [MatchedDoctorDTO]
     */
    fun matchDoctors(
        doctors: Set<Doctor>,
        symptoms: Set<Symptom>,
        location: LatLong
    ): List<MatchedDoctorDTO> {
        return doctors.map {
            matchDoctor(it, symptoms, location)
        }.sortedByDescending { it.distance }

    }

    /**
     * Retrieve a list of [MatchedDoctorDTO] from a list of doctors, symptoms, and a LatLong
     *
     * @return [MatchedDoctorDTO]
     */
    private fun matchDoctor(
        doctor: Doctor,
        symptoms: Set<Symptom>,
        location: LatLong
    ): MatchedDoctorDTO {
        val matches = doctor.specialties.map { speciality ->
            val doctorSymptoms = speciality.symptoms
            val intersection = doctorSymptoms.intersect(symptoms)
            val union = doctorSymptoms.union(symptoms)

            val similarity: Double = if (union.isEmpty()) {
                100.00
            } else {
                (intersection.size.toDouble() / doctorSymptoms.size.toDouble())
            }

            val closestPractice = doctor.practices.minByOrNull {
                location.haversineDistance(it.latLong())
            }!!

            val distance = location.haversineDistance(closestPractice.latLong())

            MatchedDoctorDTO.fromDoctor(
                doctor,
                closestPractice,
                similarity,
                distance
            )
        }
        return matches.maxBy { it.similarity }
    }
}