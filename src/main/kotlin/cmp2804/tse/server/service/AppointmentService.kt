package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.appointments.AppointmentRepository
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    private val appointmentRepository: AppointmentRepository,
    private val patientService: PatientService
): BaseService<Appointment, Long> {
    fun getAppointments(username: String): List<Appointment> {
        val patient = patientService.getPatientByUsername(username)
        return appointmentRepository.findByPatient(patient)
    }

    fun getAppointment(user: User, id: Long): Appointment {
        return appointmentRepository.findByid(id) ?: throw EntityNotFoundException("Appointment not found: $id")
    }

    fun addAppointment(appointment: Appointment): Appointment {
        return appointmentRepository.save(appointment)
    }

    fun updateAppointment(newAppointment: Appointment): Appointment {
        return appointmentRepository.save(newAppointment)
    }

    override fun getRepository(): JpaRepository<Appointment, Long> = appointmentRepository


}