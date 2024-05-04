package cmp2804.tse.server.controller

import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.storage.users.UsersRepository
import cmp2804.tse.server.util.ResponseUtils
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
@Validated
class UserController(private val usersRepository: UsersRepository) {

    @GetMapping("/{id}")
    fun getUser(
        @PathVariable(value = "id")
        userId: Long
    ): ResponseEntity<User> {
        return ResponseUtils.getEntryResponseById(usersRepository, userId)
    }

    @PostMapping("/")
    fun postUser(
        @RequestBody
        user: User
    ) {
        throw NotImplementedError()
    }

    @GetMapping("/notifications/all")
    fun getNotifications(
        user: User // TODO -> Get from login
    ): ResponseEntity<List<Notification>> {
        val notifications = notificationService.getNotifications(user)

        return ResponseEntity.ok(notifications)
    }

    @GetMapping("/notifications/new")
    fun getUnreadNotifications(
        user: User // TODO -> Get from login
    ): ResponseEntity<List<Notification>> {
        val notifications = notificationService.getNotifications(user)
            .filter { !it.seen }

        return ResponseEntity.ok(notifications)
    }

}