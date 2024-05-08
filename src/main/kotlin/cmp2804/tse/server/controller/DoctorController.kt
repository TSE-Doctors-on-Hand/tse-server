package cmp2804.tse.server.controller

import cmp2804.tse.server.dto.DoctorSearchDTO
import cmp2804.tse.server.service.DoctorService
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.ResponseUtils
import cmp2804.tse.server.util.LatLong
import cmp2804.tse.server.dto.MatchedDoctorDTO
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * Doctor controller
 *
 * **This controller has the following endpoints:**
 *
 *  - /match: This post requests retrieves all matching doctors based on the [DoctorSearchDTO] data transfer object.
 *
 *  - /{id}: This get request retrieves a doctor by their ID. Role checking is done in [DoctorService]
 *
 * @property doctorService Doctor service
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@RestController
@RequestMapping("/api/doctor")
@Validated
class DoctorController(private val doctorService: DoctorService) {

    @PostMapping("/match")
    @Transactional
    fun matchDoctors(
        @RequestBody
        doctorSearchDTO: DoctorSearchDTO,
        user: User
    ): ResponseEntity<List<MatchedDoctorDTO>> {
        // Allows for "At home" functionality, the front end sends null
        val location = if (doctorSearchDTO.postcode == null) {
            user.latLong()
        } else {
            LatLong.fromPostcode(doctorSearchDTO.postcode)
        }

        val matchedDoctors = doctorService.getMatchingDoctors(
            location,
            doctorSearchDTO.symptoms,
            doctorSearchDTO.range.toDouble(),
            doctorSearchDTO.limit
        )

        return ResponseEntity.ok(matchedDoctors)
    }

    @GetMapping("/{id}")
    fun getDoctorById(
        @PathVariable(value = "id")
        doctorId: Long
    ): ResponseEntity<Doctor> {
        return ResponseUtils.getEntryResponseById(doctorService, doctorId)
    }
}