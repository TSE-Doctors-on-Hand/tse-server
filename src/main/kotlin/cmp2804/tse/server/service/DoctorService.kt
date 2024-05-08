package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.doctors.DoctorsRepository
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.LatLong
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.dto.MatchedDoctorDTO
import cmp2804.tse.server.util.matcher.SymptomMatcher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

/**
 * Default limit of doctors to show on the results page on the front-end
 */
const val MATCHING_DOCTOR_LIMIT = 15

/**
 * Doctors service
 *
 * This service is responsible for all functions interacting with doctors
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@Service
class DoctorService(
    private val doctorsRepository: DoctorsRepository,
    private val symptomService: SymptomService
): BaseService<Doctor, Long> {

    /**
     * Retrieve a doctor by a [User]
     *
     * @return [User] if the user is a doctor
     */
    fun getDoctorByUser(user: User): Doctor {
        return doctorsRepository.findByUser(user) ?: throw EntityNotFoundException("Doctor not found: ${user.username}")
    }

    /**
     * Retrieve all doctors within a range of a [LatLong].
     *
     * This is calculated by a Dot Product instead of the haversine distance because
     * it has a lower big O and this is called multiple times without requiring a distance
     * to be calculated
     *
     * @return List of all doctors within the range
     * @see [LatLong]
     */
    fun getDoctorsInRange(center: LatLong, rangeKm: Double): List<Doctor> {
        try {
            val drs = mutableListOf<Doctor>()

            doctorsRepository.findAll().forEach { doctor ->
                doctor.practices.forEach { dr ->
                    if (dr.latLong().isWithinRange(center, rangeKm)) {
                        drs.add(doctor)
                    }
                }
            }
            return drs
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
        return listOf()
    }

    /**
     * Retrieve all doctors that are within a location that match the provided symptoms
     *
     * @param location Location of user
     * @param symptomIds List of Symptom Ids
     * @param rangeKm Range in KM, defaulting to 5km
     * @param limit Amount of doctors to show, default [MATCHING_DOCTOR_LIMIT]
     *
     * @return List of [MatchedDoctorDTO]
     * @see [MatchedDoctorDTO]
     */
    fun getMatchingDoctors(
        location: LatLong,
        symptomIds: Set<Long>,
        rangeKm: Double = 5.00,
        limit: Int = MATCHING_DOCTOR_LIMIT
    ): List<MatchedDoctorDTO> {
        val doctors = getDoctorsInRange(location, rangeKm).toSet()
        val symptoms = symptomService.getSymptomsByIds(symptomIds)

        return SymptomMatcher.matchDoctors(doctors, symptoms, location)
    }

    /**
     * Inserts all mock doctors, This function will not be used in the live version
     */
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