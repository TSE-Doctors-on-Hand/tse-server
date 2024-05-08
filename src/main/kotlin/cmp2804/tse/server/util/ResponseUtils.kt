package cmp2804.tse.server.util

import cmp2804.tse.server.service.base.BaseService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity

object ResponseUtils {

    /**
     * Generic function to retrieve an entry in any Base service by its ID
     *
     * @return [ResponseEntity] of the same type as the service
     * @author Ben Soones
     */
    fun <T : Any> getEntryResponseById(service: BaseService<T, Long>, id: Long): ResponseEntity<T> {
        return service.getRepository().findById(id).map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }
}