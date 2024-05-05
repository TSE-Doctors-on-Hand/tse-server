package cmp2804.tse.server.controller.base

import cmp2804.tse.server.service.RoleService
import cmp2804.tse.server.service.SymptomService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin")
@Validated
class AdminController(
    private val symptomService: SymptomService,
    private val roleService: RoleService
) {

    @GetMapping("/insert")
    fun insertAllData(): ResponseEntity<String> {

        val errors: MutableList<String> = mutableListOf()

        if (!symptomService.insertAllSymptoms()) {
            errors.add("Failed to insert symptoms")
        }
        if (!roleService.insertAllRoles()) {
            errors.add("Failed to insert roles")
        }


        val response = if (errors.isEmpty()) "Success" else errors.joinToString(", ")

        return ResponseEntity.ok(response)
    }
}