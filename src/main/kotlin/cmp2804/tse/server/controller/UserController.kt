package cmp2804.tse.server.controller

import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.storage.users.UsersRepository
import cmp2804.tse.server.util.ResponseUtils
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
}