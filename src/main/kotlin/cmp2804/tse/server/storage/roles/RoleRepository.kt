package cmp2804.tse.server.storage.roles

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for role storage
 *
 * @param [Role] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(rolesEnum: RolesEnum): Role?
}