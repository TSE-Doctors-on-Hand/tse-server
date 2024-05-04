package cmp2804.tse.server.controller

import cmp2804.tse.server.service.AppointmentService
import cmp2804.tse.server.service.AuthService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.appointments.AppointmentStatus
import cmp2804.tse.server.storage.users.User
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/appointment")
@Validated
class AppointmentController(
    private val appointmentService: AppointmentService,
    private val authService: AuthService
) {
    @GetMapping("/all/")
    fun getAppointments(): ResponseEntity<List<Appointment>> {
        val username = "" // TODO -> From auth

        val appointments = appointmentService.getAppointments(username)
            .sortedBy { it.date }
            .reversed()
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
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(user, id)
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
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(user, id)
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
        return ResponseEntity.ok(savedAppointment) // TODO: Error handling
    }

}