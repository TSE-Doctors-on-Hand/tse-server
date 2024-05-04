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

        val doctorSymptoms = doctor.symptoms
        val intersection = doctorSymptoms.intersect(symptoms)
        val union = doctorSymptoms.union(symptoms)

        val similarity: Double = if (union.isEmpty()) {
            100.00
        } else {
            (intersection.size.toDouble() / union.size.toDouble()) * 100
        }

        val distance = doctor.practices.map {
            location.haversineDistance(it.latLong())
        }.minOf { it }

        return MatchedDoctor(
            doctor,
            similarity,
            distance
        )


    }


}