package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.appointments.AppointmentRepository
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.error.errors.UnauthorisedException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull


/**
 * Appointment service
 *
 * This service is responsible for all aspects of an appointment
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@Service
class AppointmentService(
    private val appointmentRepository: AppointmentRepository,
    private val patientService: PatientService,
    private val doctorService: DoctorService
) : BaseService<Appointment, Long> {

    /**
     * Retrieves all appointments pertaining to a user, sorted by date.
     *
     * @return All appointments for patient, if the user's highest role is [RolesEnum.PATIENT]
     * @return All appointments for the doctor, which can be multiple patients if the user's highest role is [RolesEnum.DOCTOR]
     * @return All appointments in the database, if the user's highest role is [RolesEnum.ADMIN]
     */
    fun getAppointments(user: User): List<Appointment> {
        val role = user.getHighestRole() ?: throw EntityNotFoundException("${user.username} does not have a role.")

        val appointments: List<Appointment> = when (role) {
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

    /**
     * Retrieves an appointment by its ID
     *
     * This only retrieves the appointment if the user has permission to view the appointment.
     *
     * @return [Appointment] if found
     */
    fun getAppointment(user: User, id: Long): Appointment {
        val appointment = appointmentRepository.findById(id).getOrNull()
            ?: throw EntityNotFoundException("Appointment not found: $id")

        if (!appointment.hasViewPermission(user)) {
            throw UnauthorisedException("${user.username} does not have permission to access this appointment")
        }

        return appointment
    }

    /**
     * Adds an appointment to the registry
     *
     * @return [Appointment] added
     */
    fun addAppointment(appointment: Appointment): Appointment {
        return appointmentRepository.save(appointment)
    }

    /**
     * Updates an appointment with new information
     *
     * @return [Appointment] edited
     */
    fun updateAppointment(newAppointment: Appointment): Appointment {
        return appointmentRepository.save(newAppointment)
    }

    override fun getRepository(): JpaRepository<Appointment, Long> = appointmentRepository


}