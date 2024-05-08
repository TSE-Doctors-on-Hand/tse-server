package cmp2804.tse.server.service

import cmp2804.tse.server.dto.UserDTO
import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.storage.users.UsersRepository
import cmp2804.tse.server.util.LatLong
import cmp2804.tse.server.util.date.DateUtil
import cmp2804.tse.server.dto.RegisterDTO
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.LocalDate

/**
 * User service
 *
 * This service is responsible for all functions interacting with users
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@Service
class UserService(
    private val usersRepository: UsersRepository,
) : BaseService<User, Long> {

    private val logger = LoggerFactory.getLogger("UserService")

    /**
     * Saves a user
     *
     * @return Updated [User] object
     */
    fun save(user: User): User {
        return usersRepository.save(user)
    }

    /**
     * Retrieves a user from a [UserDTO]
     *
     * @return [User]
     */
    fun getUserFromDTO(userDTO: UserDTO): User {
        return usersRepository.findByid(userDTO.id!!)!!
    }

    /**
     * Inserts all mock users, This function will not be used in the live version
     */
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

    /**
     * Deletes a user object
     *
     * @param user User object
     *
     * @return Success boolean
     */
    fun deleteUser(user: User): Boolean {
        return try {
            usersRepository.delete(user)
            true
        } catch (e: Exception) {
            logger.error("Failed to delete ${user.username}")
            false
        }
    }

    /**
     * Retrieves a user by their username
     *
     * @param username
     *
     * @return [User] if present
     */
    fun findByUsername(username: String): User? {
        return usersRepository.findByUsername(username)
    }

    /**
     * Retrieves a user by their id
     *
     * @param id User ID
     *
     * @return [User] if present
     */
    fun findById(id: Long): User? {
        return usersRepository.findByid(id)
    }

    /**
     * Creates a user from a [RegisterDTO] and a hashed password
     *
     * @return [User]
     */
    fun createUser(registerDTO: RegisterDTO, hashedPassword: String): User {
        val latLong = LatLong.fromPostcode(registerDTO.postcode)

        val user = User(
            id = null,
            username = registerDTO.username,
            password = hashedPassword,
            forename = registerDTO.forename,
            surname = registerDTO.surname,
            dateOfBirth = DateUtil.dateOrDefault(registerDTO.dateOfBirth, Date.valueOf(LocalDate.now())),
            sex = SexEnum.values().getOrNull(registerDTO.sex) ?: SexEnum.MALE,
            pronouns = registerDTO.pronouns,
            email = registerDTO.email,
            phone = registerDTO.phone,
            homeLocationLat = latLong.latitude,
            homeLocationLong = latLong.longitude,
            postcode = registerDTO.postcode,
            nextOfKin = registerDTO.nextOfKin,
            roles = mutableSetOf(RolesEnum.PATIENT)
        )
        user.let { usersRepository.save(it) }
        return user

    }

    override fun getRepository(): JpaRepository<User, Long> = usersRepository
}