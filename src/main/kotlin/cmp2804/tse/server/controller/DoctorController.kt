package cmp2804.tse.server.controller

import cmp2804.tse.server.dto.DoctorSearchDTO
import cmp2804.tse.server.service.DoctorService
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.users.User
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

    @GetMapping("/match")
    fun matchDoctors(
        @RequestBody
        doctorSearchDTO: DoctorSearchDTO,
        user: User
    ): ResponseEntity<List<MatchedDoctor>> {
        val location = if (doctorSearchDTO.postcode == null) {
            user.latLong()
        } else {
            LatLong(0.0, 0.0) // TODO -> Add postcode to thingy
        }

        val matchedDoctors = doctorService.getMatchingDoctors(
            location,
            doctorSearchDTO.symptomIds,
            doctorSearchDTO.range.toDouble(),
            doctorSearchDTO.limit
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