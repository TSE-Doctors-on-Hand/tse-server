package cmp2804.tse.server.storage.appointments

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for appointment storage
 *
 * @param [Appointment] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface AppointmentRepository : JpaRepository<Appointment, Long> {}interface AppointmentRepository : JpaRepository<Appointment, Long> {
    fun findByPatient(patient: Patient): List<Appointment>
