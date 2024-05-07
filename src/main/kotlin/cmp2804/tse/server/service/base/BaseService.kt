package cmp2804.tse.server.service.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

interface BaseService<T: Any, ID> {

    fun getRepository(): JpaRepository<T, ID>

}