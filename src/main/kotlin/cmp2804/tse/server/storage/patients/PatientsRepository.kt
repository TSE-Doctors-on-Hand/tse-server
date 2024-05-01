package cmp2804.tse.server.storage.patients

import cmp2804.tse.server.storage.users.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for patient storage
 *
 * @param [Patient] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface PatientsRepository : JpaRepository<Patient, Long> {
    fun findByUser(user: User): Patient?
}