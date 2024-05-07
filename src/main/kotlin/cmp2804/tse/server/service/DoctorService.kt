package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.doctors.DoctorsRepository
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.LatLong
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.matcher.MatchedDoctor
import cmp2804.tse.server.util.matcher.SymptomMatcher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

private const val MATCHING_DOCTOR_LIMIT = 15

@Service
class DoctorService(
    private val doctorsRepository: DoctorsRepository
): BaseService<Doctor, Long> {

    fun getDoctorByUser(user: User): Doctor {
        return doctorsRepository.findByUser(user) ?: throw EntityNotFoundException("Doctor not found: ${user.username}")
    }

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

    fun insertDoctors(doctors: List<Doctor>): Boolean {
        return try {
            doctors.forEach { doctor ->
                if (doctorsRepository.findByUser(doctor.user) != null) return@forEach
                doctor.let { doctorsRepository.save(it) }
            }
            true
        } catch (e: Exception) {
            false
        }
    }


    override fun getRepository(): JpaRepository<Doctor, Long> = doctorsRepository
}