package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.appointments.AppointmentRepository
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.error.errors.UnauthorisedException
import io.sentry.protocol.App
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class AppointmentService(
    private val appointmentRepository: AppointmentRepository,
    private val patientService: PatientService,
    private val doctorService: DoctorService
) : BaseService<Appointment, Long> {

    fun getAppointments(user: User): List<Appointment> {
        val role = user.getHighestRole() ?: throw EntityNotFoundException("User does not have a role.")

        val appointments: List<Appointment> = when (role.name) {
            RolesEnum.PATIENT -> {
                val patient = patientService.getPatientByUser(user)
                appointmentRepository.findByPatient(patient)
            }

            RolesEnum.DOCTOR -> {
                val doctor = doctorService.getDoctorByUser(user)
                appointmentRepository.findByDoctor(doctor)
            }

            RolesEnum.ADMIN -> {
                appointmentRepository.findAll()
            }
        }

        return appointments.sortedByDescending { it.date }


    }

    fun getAppointment(user: User, id: Long): Appointment {
        val role = user.getHighestRole() ?: throw EntityNotFoundException("User does not have a role.")
        val appointment = appointmentRepository.findById(id).getOrNull()
            ?: throw EntityNotFoundException("Appointment not found: $id")

        if (!appointment.hasViewPermission(user)) {
            throw UnauthorisedException("${user.username} does not have permission to access this appointment")
        }

        return appointment
    }

    fun addAppointment(appointment: Appointment): Appointment {
        return appointmentRepository.save(appointment)
    }

    fun updateAppointment(newAppointment: Appointment): Appointment {
        return appointmentRepository.save(newAppointment)
    }

    override fun getRepository(): JpaRepository<Appointment, Long> = appointmentRepository


}