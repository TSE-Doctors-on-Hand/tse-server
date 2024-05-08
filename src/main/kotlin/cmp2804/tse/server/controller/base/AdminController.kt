package cmp2804.tse.server.controller.base

import cmp2804.tse.server.service.*
import mock.data.MOCK_DOCTORS
import mock.data.MOCK_PATIENTS
import mock.data.MOCK_PRACTICES
import mock.data.MOCK_USERS
import mock.data.symptom.MockSpecialties
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Controller for all admin purposes
 *
 * ** This controller has the following endpoints:
 *
 *  - /insert: This get request inserts mock data into the database
 *  and must be run when the backend is started for the first time
 *
 * @property symptomService Symptoms service
 * @property patientService Patient service
 * @property doctorService Doctor service
 * @property userService User service
 * @property specialityService Specialty service
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@RestController
@RequestMapping("/api/admin")
@Validated
class AdminController(
    private val symptomService: SymptomService,
    private val patientService: PatientService,
    private val doctorService: DoctorService,
    private val userService: UserService,
    private val specialityService: SpecialityService,
    private val practiceService: PracticeService
) {

    @GetMapping("/insert")
    fun insertAllData(): ResponseEntity<String> {

        val errors: MutableList<String> = mutableListOf()

        // Adding constants, this is required
        if (!symptomService.insertAllSymptoms()) {
            errors.add("Failed to insert symptoms")
        }

        // Adding mock data for testing purposes
        if (!specialityService.insertSpecialities(MockSpecialties.all())) {
            errors.add("Failed to insert specialities")
        }
        if (!userService.insertUsers(MOCK_USERS)) {
            errors.add("Failed to insert users")
        }
        if (!patientService.insertPatients(MOCK_PATIENTS)) {
            errors.add("Failed to insert patients")
        }
        if (!practiceService.insertPractices(MOCK_PRACTICES)) {
            errors.add("Failed to insert practices")

        }
        if (!doctorService.insertDoctors(MOCK_DOCTORS)) {
            errors.add("Failed to insert doctors")
        }


        val response = if (errors.isEmpty()) "Success" else errors.joinToString(", ")

        return ResponseEntity.ok(response)
    }
}