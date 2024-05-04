package cmp2804.tse.server.service.base

import org.springframework.data.jpa.repository.JpaRepository

interface BaseService<T, ID> {
    fun getRepository(): JpaRepository<T, ID>
}