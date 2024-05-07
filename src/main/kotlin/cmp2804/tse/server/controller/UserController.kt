package cmp2804.tse.server.controller

import cmp2804.tse.server.service.NotificationService
import cmp2804.tse.server.service.UserService
import cmp2804.tse.server.storage.notifications.Notification
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.ResponseUtils
import cmp2804.tse.server.util.resposne.UNAUTHORIZED_MESSAGE
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
@Validated
class UserController(
    private val userService: UserService,
    private val notificationService: NotificationService
) {

    @GetMapping("/{id}")
    fun getUser(
        @PathVariable(value = "id")
        userId: Long
    ): ResponseEntity<User> {
        // TODO -> Ensure only right users can access this
        return ResponseUtils.getEntryResponseById(userService, userId)
    }

    @PutMapping("/")
    fun putUser(
        @RequestBody
        newUser: User,
        user: User
    ): ResponseEntity<Any> {
        if (newUser.id != user.id) {
            return ResponseEntity.badRequest().body(UNAUTHORIZED_MESSAGE)
        }
        val responseUser = userService.save(newUser)
        return ResponseEntity.ok(responseUser)
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
    ) {
        userService
    }

}