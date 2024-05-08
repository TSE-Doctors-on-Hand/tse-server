package cmp2804.tse.server.service.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

/**
 * Generic interface for Services
 *
 * This is responsible for functional integrity for all services
 *
 * @author Ben Soones
 */
interface BaseService<T: Any, ID> {

    /**
     * Returns the primary repository of the service
     */
    fun getRepository(): JpaRepository<T, ID>

}