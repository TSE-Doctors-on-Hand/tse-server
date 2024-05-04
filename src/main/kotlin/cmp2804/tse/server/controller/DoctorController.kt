package cmp2804.tse.server.controller

import cmp2804.tse.server.service.DoctorService
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.util.ResponseUtils
import cmp2804.tse.server.util.LatLong
import cmp2804.tse.server.util.matcher.MatchedDoctor
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/doctor")
@Validated
class DoctorController(private val doctorService: DoctorService) {

    @GetMapping("/match/{lat}/{long}/{range}/{limit}")
    fun matchDoctors(
        @PathVariable lat: Double,
        @PathVariable long: Double,
        @PathVariable range: Double,
        @PathVariable(required = false) limit: Int,
        @RequestParam(required = true) symptoms: List<Symptom>
    ): ResponseEntity<List<MatchedDoctor>> {
        val currentPos = LatLong(lat, long)
        val matchedDoctors = doctorService.getMatchingDoctors(
            currentPos,
            symptoms.toSet(),
            range,
            limit
        )

        return ResponseEntity.ok(matchedDoctors)
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    fun getDoctorById(
        @PathVariable(value = "id")
        doctorId: Long
    ): ResponseEntity<Doctor> {
        return ResponseUtils.getEntryResponseById(doctorService, doctorId)
    }
}