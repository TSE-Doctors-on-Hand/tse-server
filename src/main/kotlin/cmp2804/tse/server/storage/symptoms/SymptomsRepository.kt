package cmp2804.tse.server.storage.symptoms

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for symptom storage
 *
 * @param [Symptom] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface SymptomsRepository : JpaRepository<Symptom, Long> {
    fun findByName(name: String): Symptom?
}