package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.roles.Role
import cmp2804.tse.server.storage.roles.RoleRepository
import cmp2804.tse.server.storage.roles.RolesEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val roleRepository: RoleRepository
): BaseService<Role, Long> {

    fun getRole(roleEnum: RolesEnum): Role? = roleRepository.findByName(roleEnum)

    override fun getRepository(): JpaRepository<Role, Long> = roleRepository

}