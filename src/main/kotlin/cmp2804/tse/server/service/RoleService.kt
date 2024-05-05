package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.roles.Role
import cmp2804.tse.server.storage.roles.RoleRepository
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.symptoms.SYMPTOMS
import cmp2804.tse.server.storage.symptoms.Symptom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val roleRepository: RoleRepository
): BaseService<Role, Long> {

    fun getRole(roleEnum: RolesEnum): Role? = roleRepository.findByName(roleEnum)

    fun insertAllRoles(): Boolean {
        try {
            RolesEnum.values().forEach { role ->
                if (roleRepository.findByName(role) != null) return@forEach

                val newRole = Role(
                    id = null,
                    name = role,
                    setOf()
                )
                newRole.let { roleRepository.save(it) }
            }
            return true
        } catch (e: Exception) {
            return false
        }

    }

    override fun getRepository(): JpaRepository<Role, Long> = roleRepository

}