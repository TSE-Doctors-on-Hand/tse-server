package cmp2804.tse.server.controller

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.doctors.DoctorsRepository
import cmp2804.tse.server.util.ResponseUtils
import cmp2804.tse.server.util.LatLong
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/doctor")
@Validated
class DoctorController(private val doctorsRepository: DoctorsRepository) {

    // Gets all doctors within km range
    @GetMapping("/range/{lat}/{long}/{range}")
    fun getDoctorsInRange(
        @PathVariable(value = "lat")
        lat: Double,
        @PathVariable(value = "long")
        long: Double,
        @PathVariable(value = "range") // In KM
        range: Double,
    ): ResponseEntity<List<Doctor>> {
        val currentPos = LatLong(lat, long)

        val doctors = doctorsRepository.findAll().filter { doctor ->
            doctor.practices.any { practice ->
                currentPos.isInRange(practice.location, range)
            }
        }
        return if (doctors.isEmpty()) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(doctors)
        }
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    fun getDoctorById(
        @PathVariable(value = "id")
        doctorId: Long
    ): ResponseEntity<Doctor> {
        return ResponseUtils.getEntryResponseById(doctorsRepository, doctorId)
    }
}