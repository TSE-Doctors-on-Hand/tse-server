package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.patients.PatientsRepository
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.dto.RegisterDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

/**
 * Patient service
 *
 * This service is responsible for all functions interacting with patients
 *
 * @author Ben Soones
 */
@Service
class PatientService(
    private val patientsRepository: PatientsRepository,
    private val userService: UserService
): BaseService<Patient, Long> {

    /**
     * Retrieves a patient by their [User] object
     *
     * @return [User] if the user is a patient
     * @throws [EntityNotFoundException] if user is not a patient
     */
    fun getPatientByUser(user: User): Patient {
        return patientsRepository.findByUser(user) ?: throw EntityNotFoundException("Patient not found: ${user.username}")
    }

    /**
     * Creates a user and patient via the registration screen.
     *
     * @see [AuthService]
     */
    fun createPatient(registerDTO: RegisterDTO, hashedPassword: String): Patient {
        val user = userService.createUser(registerDTO, hashedPassword)

        val patient = Patient(
            user = user
        )
        patient.let { patientsRepository.save(it) }
        return patient
    }

    /**
     * Inserts all mock patients, This function will not be used in the live version
     */
    fun insertPatients(patients: List<Patient>): Boolean {
        return try {
            patients.forEach { patient ->
                if (patientsRepository.findByUser(patient.user) != null) return@forEach
                patient.let { patientsRepository.save(it) }
            }
            true
        } catch (e: Exception) {
            false
        }
    }


    override fun getRepository(): JpaRepository<Patient, Long> = patientsRepository
}