package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.storage.users.UsersRepository
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.request.SignUpRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val usersRepository: UsersRepository,
    private val patientService: PatientService,
    private val roleService: RoleService
) : BaseService<User, Long> {

    fun save(user: User): User {
        return usersRepository.save(user)
    }

    fun deleteUser(user: User): Boolean {
        return try {
            usersRepository.delete(user)
            true
        } catch (e: Exception) {
            // TODO -> Logging
            false
        }
    }

    fun getUserByUsername(username: String): User {
        return usersRepository.findByUsername(username)
            ?: throw EntityNotFoundException("Username not found: $username")
    }

    fun findByUsername(username: String): User? {
        return usersRepository.findByUsername(username)
    }

    fun findById(id: Long): User? {
        return usersRepository.findByid(id)
    }

    fun createUser(signUpRequest: SignUpRequest, hashedPassword: String): User {
        val user = User(
            id = null,
            username = signUpRequest.username,
            password = hashedPassword,
            forename = signUpRequest.forename,
            surname = signUpRequest.surname,
            dateOfBirth = signUpRequest.dateOfBirth,
            sex = SexEnum.values().getOrNull(signUpRequest.sex) ?: SexEnum.MALE,
            pronouns = signUpRequest.pronouns,
            email = signUpRequest.email,
            phone = signUpRequest.phone,
            homeLocationLat = signUpRequest.homeLocationLat,
            homeLocationLong = signUpRequest.homeLocationLong,
            nextOfKin = signUpRequest.nextOfKin,
            roles = setOf(
                roleService.getRole(RolesEnum.PATIENT)!!
            )
        )
        user.let { usersRepository.save(it) }
        patientService.createPatient(user)
        return user

    }

    fun getNotifications() {

    }


    override fun getRepository(): JpaRepository<User, Long> = usersRepository
}