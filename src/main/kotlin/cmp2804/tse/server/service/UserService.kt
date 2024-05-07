package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.storage.users.UsersRepository
import cmp2804.tse.server.util.LatLong
import cmp2804.tse.server.util.date.DateUtil
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.request.SignUpRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.Instant
import java.time.LocalDate

@Service
class UserService(
    private val usersRepository: UsersRepository,
) : BaseService<User, Long> {

    fun save(user: User): User {
        return usersRepository.save(user)
    }

    fun insertUsers(users: List<User>): Boolean {
        return try {
            users.forEach { user ->
                if (usersRepository.findByUsername(user.username) != null) return@forEach
                user.let { usersRepository.save(it) }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
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

        // TODO -> Turn postcode into lat long
        val latLong = LatLong.fromPostcode(signUpRequest.postcode)

        val user = User(
            id = null,
            username = signUpRequest.username,
            password = hashedPassword,
            forename = signUpRequest.forename,
            surname = signUpRequest.surname,
            dateOfBirth = DateUtil.dateOrDefault(signUpRequest.dateOfBirth, Date.valueOf(LocalDate.now())),
            sex = SexEnum.values().getOrNull(signUpRequest.sex) ?: SexEnum.MALE,
            pronouns = signUpRequest.pronouns,
            email = signUpRequest.email,
            phone = signUpRequest.phone,
            homeLocationLat = latLong.latitude,
            homeLocationLong = latLong.longitude,
            postcode = signUpRequest.postcode,
            nextOfKin = signUpRequest.nextOfKin,
            roles = mutableSetOf(RolesEnum.PATIENT)
        )
        user.let { usersRepository.save(it) }
        return user

    }

    fun getNotifications() {

    }


    override fun getRepository(): JpaRepository<User, Long> = usersRepository
}