package cmp2804.tse.server.storage.users

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for user storage
 *
 * @param [User] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface UsersRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByid(id: Long): User?
}