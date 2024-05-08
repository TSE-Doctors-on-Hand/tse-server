package cmp2804.tse.server.controller

import cmp2804.tse.server.dto.UserDTO
import cmp2804.tse.server.service.NotificationService
import cmp2804.tse.server.service.UserService
import cmp2804.tse.server.storage.notifications.Notification
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.ResponseUtils
import cmp2804.tse.server.util.error.errors.UnauthorisedException
import cmp2804.tse.server.util.resposne.UNAUTHORIZED_MESSAGE
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * User controller
 *
 * The user controller uses method injection to add the [User] object by the request token and is inserted
 * via the argument "user". This is done to ensure that only the valid user can view the data.
 * This is done in [cmp2804.tse.server.util.auth.UserArgumentResolver]
 *
 * **This controller has the following endpoints:**
 **
 *  - /all: This get request retrieves all symptoms. This is not a protected endpoint and does not need any permission checks#
 *
 *  - /: This get request retrieves the current user.
 *
 *  - /: This put request edits the sender's information
 *
 *  - /: This delete request deletes the sender's user information
 *
 *  - /{id}: This get requests retrieves a user by their ID. This is accessible by a patient if it is their own ID or by a doctor as they are
 *  allowed to view all patients.
 *
 *  - /notifications/all: This get request retrieves all notifications from the sender.
 *
 *  - /notifications/new: This get requests retrieves all unread notifications from the sender.
 *
 * @property userService User service
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@RestController
@RequestMapping("/api/user")
@Validated
class UserController(
    private val userService: UserService,
    private val notificationService: NotificationService,
) {

    @GetMapping("/")
    fun getSelfUser(
        user: User
    ): ResponseEntity<UserDTO> {
        return ResponseEntity.ok(
            UserDTO.fromUser(user)
        )
    }

    @PutMapping("/")
    fun putUser(
        @RequestBody
        newUser: UserDTO,
        user: User
    ): ResponseEntity<Any> {
        // Ensuring you can only edit your profile
        if (newUser.id != user.id) throw UnauthorisedException()

        val responseUser = userService.save(userService.getUserFromDTO(newUser))
        return ResponseEntity.ok(UserDTO.fromUser(responseUser))
    }

    @DeleteMapping("/")
    fun deleteUser(
        user: User
    ): ResponseEntity<UserDTO> {
        return if (userService.deleteUser(user)) {
            ResponseEntity.ok(UserDTO.fromUser(user))
        } else {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    fun getUser(
        @PathVariable(value = "id")
        userId: Long,
        user: User
    ): ResponseEntity<*> {
        // Ensuring user is allowed to view the requested user
        if (user.id != userId && !user.isDoctor()) throw UnauthorisedException()

        val requestedUser = ResponseUtils.getEntryResponseById(userService, userId)
        if (requestedUser.statusCode != HttpStatus.OK) return requestedUser

        return ResponseEntity.ok(UserDTO.fromUser(requestedUser.body!!))
    }

    @GetMapping("/notifications/all")
    fun getNotifications(
        user: User
    ): ResponseEntity<List<Notification>> {
        val notifications = notificationService.getNotifications(user)

        return ResponseEntity.ok(notifications)
    }

    @GetMapping("/notifications/new")
    fun getUnreadNotifications(
        user: User
    ): ResponseEntity<List<Notification>> {
        val notifications = notificationService.getNotifications(user)
            .filter { !it.seen }

        return ResponseEntity.ok(notifications)
    }



}