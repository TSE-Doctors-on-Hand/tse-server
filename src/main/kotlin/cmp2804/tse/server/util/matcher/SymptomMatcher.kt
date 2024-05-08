package cmp2804.tse.server.util.matcher

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.util.LatLong

object SymptomMatcher {
    fun matchDoctors(
        doctors: Set<Doctor>,
        symptoms: Set<Symptom>,
        location: LatLong
    ): List<MatchedDoctor> {

        return doctors.map {
            matchDoctor(it, symptoms, location)
        }.sortedByDescending { it.distance }

    }

    private fun matchDoctor(
        doctor: Doctor,
        symptoms: Set<Symptom>,
        location: LatLong
    ): MatchedDoctor {
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

            MatchedDoctor.fromDoctor(
                doctor,
                closestPractice,
                similarity,
                distance
            )
        }

        return matches.maxBy { it.similarity }


    }


}