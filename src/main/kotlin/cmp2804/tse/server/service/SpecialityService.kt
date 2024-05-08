package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.specialties.Speciality
import cmp2804.tse.server.storage.specialties.SpecialtiesRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

/**
 * Specialty service
 *
 * This service is responsible for all functions interacting with specialties
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@Service
class SpecialityService(
    private val specialityRepository: SpecialtiesRepository
): BaseService<Speciality, Long> {

    /**
     * Inserts all mock specialties, This function will not be used in the live version
     */
    fun insertSpecialities(specialities: List<Speciality>): Boolean {
        return try {
            specialities.forEach { speciality ->
                if (specialityRepository.findByName(speciality.name) != null) return@forEach
                speciality.let { specialityRepository.save(it) }
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getRepository(): JpaRepository<Speciality, Long> = specialityRepository

}