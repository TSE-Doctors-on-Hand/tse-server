package cmp2804.tse.server.util

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity

object ResponseUtils {

    // TODO -> Javadoc
    fun <T> getEntryResponseById(repository: JpaRepository<T, Long>, id: Long): ResponseEntity<T> {
        return repository.findById(id).map { ResponseEntity.ok(it) }.orElse(ResponseEntity.notFound().build())
    }
}