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

    fun getDoctorsInRange(latLong: LatLong, rangeKm: Double): List<Doctor> {
        val doctors = doctorsRepository.findAll().filter { doctor ->
            doctor.practices.any { practice ->
                latLong.isInRange(practice.locationLat, practice.locationLong, rangeKm)
            }
        }

        return doctors
    }

    fun getMatchingDoctors(symptoms: List<Symptom>, limit: Int = MATCHING_DOCTOR_LIMIT) {
        // For now, this will check ALL doctors, regardless of location


    }

}