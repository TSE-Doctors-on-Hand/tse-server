package cmp2804.tse.server.storage.doctors

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for doctor storage
 *
 * @param [Doctor] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface DoctorsRepository : JpaRepository<Doctor, Long> {}