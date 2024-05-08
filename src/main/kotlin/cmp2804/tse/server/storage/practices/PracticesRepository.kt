package cmp2804.tse.server.storage.practices

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for practice storage
 *
 * @param [Practice] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface PracticesRepository : JpaRepository<Practice, Long> {
    fun findByName(name: String): Practice?
}