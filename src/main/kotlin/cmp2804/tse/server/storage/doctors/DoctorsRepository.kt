package cmp2804.tse.server.storage.doctors

import cmp2804.tse.server.storage.users.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for doctor storage
 *
 * @param [Doctor] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface DoctorsRepository : JpaRepository<Doctor, Long> {
    fun findByUser(user: User): Doctor?
}