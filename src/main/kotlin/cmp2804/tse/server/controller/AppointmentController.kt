package cmp2804.tse.server.controller

import cmp2804.tse.server.service.AppointmentService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.appointments.AppointmentStatus
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.util.resposne.UNAUTHORIZED_MESSAGE
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Appointment controller
 *
 * **This controller has the following endpoints:**
 *
 *  - /: This put request adds an appointment to the database. Error checking is handled by the [AppointmentService]
 *
 *  - /all: This get request retrieves all appointments. Role checking is built in via the [AppointmentService].
 *
 *  - /{id}: This get request retrieves an appointment by its ID.
 *
 *  - /{id}/status: This get request retrieves the status of an appointment.
 *
 *  - /{id}/status: This put request edits the status of an appointment. Role checking is build in via the [AppointmentService].
 *
 *  - /{id}/date/suggest: This post request suggests a date (by a doctor) for an appointment. The status is edited accordingly.
 *
 *  - /{id}/date/approve: This post request approves a date (by a patient) for an appointment. The status is edited accordingly.
 *
 *  - /{id}/date/reject: This post request rejects a date (by a patient OR doctor) for an appointment. The status goes back accordingly.
 *
 * @property appointmentService Appointment service
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@RestController
@RequestMapping("/api/appointment")
@Validated
class AppointmentController(
    private val appointmentService: AppointmentService,
) {
    @GetMapping("/all")
    fun getAppointments(
        user: User
    ): ResponseEntity<List<Appointment>> {
        val appointments = appointmentService.getAppointments(user)
        return ResponseEntity.ok(appointments)
    }

    @GetMapping("/{id}")
    fun getAppointment(
        @PathVariable(name = "id")
        id: Long,
        user: User // This should be automatically resolved
    ): ResponseEntity<Any> {
        val appointment = appointmentService.getAppointment(user, id)
        return ResponseEntity.ok(appointment)
    }

    @GetMapping("/{id}/status")
    fun getStatus(
        @PathVariable(name = "id")
        id: Long,
        user: User
    ): ResponseEntity<Int> {
        val appointment = appointmentService.getAppointment(user, id)
        val status = appointment.status

        return ResponseEntity.ok(status)
    }

    @PutMapping("/{id}/status")
    fun putStatus(
        @PathVariable("id")
        id: Long,
        @RequestBody
        newStatus: Int,
        user: User
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(user, id)
        appointment.status = newStatus

        val newAppointment = appointmentService.updateAppointment(appointment)

        return ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/{id}/date/suggest")
    fun suggestDate(
        @PathVariable
        id: Long,
        @RequestBody
        suggestedDateTime: Long,
        user: User
    ): ResponseEntity<Any> {
        val appointment = appointmentService.getAppointment(user, id)

        if (!appointment.hasDoctorPermission(user)) {
            return ResponseEntity.badRequest().body(UNAUTHORIZED_MESSAGE)
        }

        appointment.date = suggestedDateTime
        appointment.status = AppointmentStatus.AWAITING_CONFIRMATION.index
        val newAppointment = appointmentService.updateAppointment(appointment)
        return ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/{id}/date/approve")
    fun approveDate(
        @PathVariable
        id: Long,
        user: User
    ): ResponseEntity<Any> {
        val appointment = appointmentService.getAppointment(user, id)

        if (!appointment.hasDoctorPermission(user)) {
            return ResponseEntity.badRequest().body(UNAUTHORIZED_MESSAGE)
        }

        appointment.status = AppointmentStatus.CONFIRMED.index
        val newAppointment = appointmentService.updateAppointment(appointment)
        return ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/{id}/date/reject")
    fun rejectDate(
        @PathVariable
        id: Long,
        @RequestBody
        newDateTimes: MutableSet<Long>,
        user: User
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(user, id)
        appointment.status = AppointmentStatus.REVIEWED.index
        appointment.availableDates = newDateTimes
        val newAppointment = appointmentService.updateAppointment(appointment)
        return ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/")
    fun postAppointment(
        @RequestBody
        appointment: Appointment,
        user: User
    ): ResponseEntity<Appointment> {
        val savedAppointment = appointmentService.addAppointment(appointment)
        return ResponseEntity.ok(savedAppointment)
    }

}