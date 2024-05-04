package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.patients.PatientsRepository
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class PatientService(
    private val patientsRepository: PatientsRepository,
    private val userService: UserService
): BaseService<Patient, Long> {
    fun getPatientByUsername(username: String): Patient {
        val user = userService.getUserByUsername(username)
        return patientsRepository.findByUser(user) ?: throw EntityNotFoundException("Patient not found: $username")
    }

    override fun getRepository(): JpaRepository<Patient, Long> = patientsRepository
}