package cmp2804.tse.server.controller

import cmp2804.tse.server.service.AppointmentService
import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.appointments.AppointmentStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/appointment")
@Validated
class AppointmentController(
    private val appointmentService: AppointmentService
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
        id: Long
    ): ResponseEntity<Appointment?> {
        val appointment = appointmentService.getAppointment(id)
        return ResponseEntity.ok(appointment)
    }

    @GetMapping("/{id}/status")
    fun getStatus(
        @PathVariable(name = "id")
        id: Long
    ): ResponseEntity<Int> {
        val appointment = appointmentService.getAppointment(id)
        val status = appointment.status

        return ResponseEntity.ok(status)
    }

    @PutMapping("/{id}/status")
    fun putStatus(
        @PathVariable("id")
        id: Long,
        @RequestBody
        newStatus: Int
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(id)
        appointment.status = newStatus

        val newAppointment = appointmentService.updateAppointment(appointment)

        return ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/{id}/date/suggest")
    fun suggestDate(
        @PathVariable
        id: Long,
        @RequestBody
        suggestedDateTime: LocalDateTime
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(id)
        appointment.date = suggestedDateTime
        appointment.status = AppointmentStatus.AWAITING_CONFIRMATION.index
        val newAppointment = appointmentService.updateAppointment(appointment)
        return  ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/{id}/date/reject")
    fun approveDate(
        @PathVariable
        id: Long,
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(id)
        appointment.status = AppointmentStatus.CONFIRMED.index
        val newAppointment = appointmentService.updateAppointment(appointment)
        return  ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/{id}/date/reject")
    fun rejectDate(
        @PathVariable
        id: Long,
        @RequestBody
        newDateTimes: MutableSet<LocalDateTime>
    ): ResponseEntity<Appointment> {
        val appointment = appointmentService.getAppointment(id)
        appointment.status = AppointmentStatus.REVIEWED.index
        appointment.availableDates = newDateTimes
        val newAppointment = appointmentService.updateAppointment(appointment)
        return  ResponseEntity.ok(newAppointment)
    }

    @PostMapping("/")
    fun postAppointment(
        @RequestBody
        appointment: Appointment
    ): ResponseEntity<Appointment> {
        val savedAppointment = appointmentService.addAppointment(appointment)
        return ResponseEntity.ok(savedAppointment) // TODO: Error handling
    }

}