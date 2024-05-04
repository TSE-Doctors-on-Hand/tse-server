package cmp2804.tse.server.service

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.doctors.DoctorsRepository
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.util.LatLong
import org.springframework.stereotype.Service

private const val MATCHING_DOCTOR_LIMIT = 15

@Service
class DoctorService(
    private val doctorsRepository: DoctorsRepository
) {

    fun getDoctorsInRange(center: LatLong, rangeKm: Double): List<Doctor> {
        val doctors = doctorsRepository.findAll().filter { doctor ->
            doctor.practices.any { practice ->
                practice.latLong().isWithinRange(center, rangeKm)
            }
        }

        return doctors
    }

    fun getMatchingDoctors(
        location: LatLong,
        symptoms: Set<Symptom>,
        rangeKm: Double = 5.00,
        limit: Int = MATCHING_DOCTOR_LIMIT
    ): List<MatchedDoctor> {
        val doctors = getDoctorsInRange(location, rangeKm).toSet()

        return SymptomMatcher.matchDoctors(doctors, symptoms, location)
    }

}