package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.patients.PatientsRepository
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.request.SignUpRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class PatientService(
    private val patientsRepository: PatientsRepository,
    private val userService: UserService
): BaseService<Patient, Long> {

    fun getPatientByUser(user: User): Patient {
        return patientsRepository.findByUser(user) ?: throw EntityNotFoundException("Patient not found: ${user.username}")
    }

    fun getPatientByUsername(username: String): Patient {
        val user = userService.getUserByUsername(username)
        return patientsRepository.findByUser(user) ?: throw EntityNotFoundException("Patient not found: $username")
    }

    fun createPatient(signUpRequest: SignUpRequest, hashedPassword: String): Patient {
        val user = userService.createUser(signUpRequest, hashedPassword)

        val patient = Patient(
            user = user
        )
        patient.let { patientsRepository.save(it) }
        return patient
    }


    override fun getRepository(): JpaRepository<Patient, Long> = patientsRepository
}