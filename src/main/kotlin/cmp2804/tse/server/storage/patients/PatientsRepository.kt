package cmp2804.tse.server.storage.patients

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for patient storage
 *
 * @param [Patient] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface PatientsRepository : JpaRepository<Patient, Long> {}