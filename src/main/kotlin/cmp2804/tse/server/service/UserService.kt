package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.storage.users.UsersRepository
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.request.SignUpRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val usersRepository: UsersRepository,
): BaseService<User, Long>  {

    fun save(user: User): User {
        return usersRepository.save(user)
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
        // TODO -> Validation
        val user = User(
            username = signUpRequest.username,
            password = hashedPassword,
            forename = signUpRequest.forename,
            surname = signUpRequest.surname,
            dateOfBirth = signUpRequest.dateOfBirth,
            sex = signUpRequest.sex,
            pronouns = signUpRequest.pronouns,
            email = signUpRequest.email,
            phone = signUpRequest.phone,
            homeLocationLat = signUpRequest.homeLocationLat,
            homeLocationLong = signUpRequest.homeLocationLong,
            nextOfKin = signUpRequest.nextOfKin,
            roles = setOf()
        )
        user.let { usersRepository.save(it) }

        return user
    }

    fun getNotifications() {

    }


    override fun getRepository(): JpaRepository<User, Long> = usersRepository
}