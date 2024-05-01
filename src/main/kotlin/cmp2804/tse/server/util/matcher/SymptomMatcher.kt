package cmp2804.tse.server.util.matcher

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.symptoms.Symptom

object SymptomMatcher {
    fun matchSymptoms(
        patient: Patient,
        symptoms: List<Symptom>
        ) {
        // Get all doctors
        // Filter by symptom

    }

    fun matchDoctors(
        doctors: List<Doctor>,
        symptoms: List<Symptom>
        ){

    }

    fun matchDoctor(
        doctor: Doctor,
        symptoms: Set<Symptom>
    ){ // : MatchedDoctor {
        val similarity: Double

        val doctorSymptoms = doctor.symptoms
        val intersection = doctorSymptoms.intersect(symptoms)
        val union = doctorSymptoms.union(symptoms)

        similarity = if (union.isEmpty()) {
            100.00
        } else {
            (intersection.size.toDouble() / union.size.toDouble()) * 100
        }


    }



}