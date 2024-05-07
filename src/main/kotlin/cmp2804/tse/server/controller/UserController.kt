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

    @GetMapping("/{id}")
    fun getUser(
        @PathVariable(value = "id")
        userId: Long,
        user: User
    ): ResponseEntity<*> {
        // Ensuring user is allowed to view
        if (user.id != userId && !user.isDoctor()) throw UnauthorisedException()

        val requestedUser = ResponseUtils.getEntryResponseById(userService, userId)
        if (requestedUser.statusCode != HttpStatus.OK) return requestedUser

        return ResponseEntity.ok(UserDTO.fromUser(requestedUser.body!!))
    }

    @PutMapping("/")
    fun putUser(
        @RequestBody
        newUser: UserDTO,
        user: User
    ): ResponseEntity<Any> {
        if (newUser.id != user.id) {
            return ResponseEntity.badRequest().body(UNAUTHORIZED_MESSAGE)
        }
        val responseUser = userService.save(newUser.toUser())
        return ResponseEntity.ok(UserDTO.fromUser(responseUser))
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

}