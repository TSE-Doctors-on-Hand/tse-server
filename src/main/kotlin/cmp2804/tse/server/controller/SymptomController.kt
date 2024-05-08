package cmp2804.tse.server.controller

import cmp2804.tse.server.service.SymptomService
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.util.ResponseUtils
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * Symptom controller
 *
 * **This controller has the following endpoints:**
 **
 *  - /all: This get request retrieves all symptoms. This is not a protected endpoint and does not need any permission checks#
 *
 *  - /{id}}: This get request retrieves a symptom by its ID. This is not a protected endpoint and does not need any permission checks#
 *
 *
 * @property symptomService Symptom service
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@RestController
@RequestMapping("/api/symptom")
@Validated
class SymptomController(private val symptomService: SymptomService) {

    @GetMapping("/all")
    fun getAllSymptoms(): ResponseEntity<List<Symptom>>{
        val symptoms = symptomService.getAllSymptoms()
        return ResponseEntity.ok(symptoms)
    }

    @GetMapping("/{id}")
    fun getSymptomById(
        @PathVariable(value = "id")
        symptomId: Long
    ): ResponseEntity<Symptom> {
        return ResponseUtils.getEntryResponseById(symptomService, symptomId)
    }
}