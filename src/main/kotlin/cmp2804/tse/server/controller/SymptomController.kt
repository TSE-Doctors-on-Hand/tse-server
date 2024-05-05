package cmp2804.tse.server.controller

import cmp2804.tse.server.service.SymptomService
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.util.ResponseUtils
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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