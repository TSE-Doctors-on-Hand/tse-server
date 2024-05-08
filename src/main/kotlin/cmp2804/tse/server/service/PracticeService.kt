package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.practices.Practice
import cmp2804.tse.server.storage.practices.PracticesRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

/**
 * Practice service
 *
 * This service is responsible for all functions interacting with practices
 *
 * @author Ben Soones
 */
@Service
class PracticeService(
    private val practicesRepository: PracticesRepository
): BaseService<Practice, Long> {

    /**
     * Inserts all mock practices, This function will not be used in the live version
     */
    fun insertPractices(practices: List<Practice>): Boolean {
        return try {
            practices.forEach { practice ->
                if (practicesRepository.findByName(practice.name) != null) return@forEach
                practice.let { practicesRepository.save(it) }
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getRepository(): JpaRepository<Practice, Long> = practicesRepository

}