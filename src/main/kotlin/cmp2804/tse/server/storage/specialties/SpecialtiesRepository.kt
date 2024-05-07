package cmp2804.tse.server.storage.specialties

import cmp2804.tse.server.storage.specialties.Speciality
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for doctor storage
 *
 * @param [Speciality] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface SpecialtiesRepository : JpaRepository<Speciality, Long> {
    fun findByName(name: String): Speciality?
}