package cmp2804.tse.server.storage.appointments

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.patients.Patient
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for appointment storage
 *
 * @param [Appointment] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface AppointmentRepository : JpaRepository<Appointment, Long> {
    fun findByPatient(patient: Patient): List<Appointment>
    fun findByDoctor(doctor: Doctor): List<Appointment>

}