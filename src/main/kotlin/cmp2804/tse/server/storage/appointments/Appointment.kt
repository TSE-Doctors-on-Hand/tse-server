package cmp2804.tse.server.storage.appointments

import cmp2804.tse.server.storage.doctors.DOCTOR_TABLE_NAME
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.practices.PRACTICE_TABLE_NAME
import cmp2804.tse.server.storage.practices.Practice
import java.sql.Date
import javax.persistence.*

const val APPOINTMENT_TABLE_NAME = "appointments"

/**
 * **Appointments table**
 *
 * Stores all information about an appointment
 *
 * @author Ben Soones
 */
@Entity
@Table(name = APPOINTMENT_TABLE_NAME)
data class Appointment(
    @Id
    @GeneratedValue
    val id: Long,

    /**
     * Appointment doctor:
     *
     * The doctor selected to handle an appointment
     *
     * @see Doctor
     */
    @JoinColumn(name = "${DOCTOR_TABLE_NAME}_id")
    @OneToOne(mappedBy = DOCTOR_TABLE_NAME, cascade = [CascadeType.ALL])
    val doctor: Doctor,

    /**
     * Patient chosen list of available dates
     */
    @ElementCollection
    val availableDates: MutableSet<Date>,

    /**
     * * A Latitude and Longitude pair showing the GPS co-ordinates of the practice
     * This can be used with a maps API to get the location.
     *
     * The source location of the appointment.
     * This will be the centre of any radius
     * calculation
     *
     * This is not relational to a User's address
     * because there are conditions where a user's
     * chosen location may not be their actual location
     * (e.g. when they're at University)
     */
    val homeLocation: Pair<Double, Double>,

    /**
     * Acceptable range
     *
     * Extra information for doctors to use to recommend another
     * doctor / practice
     *
     * **NOTE: THE RANGE IS IN MILES**
     */
    val range: Double,

    /**
     * Accessibility feature: Allow for home visits just like the NHS
     *
     * @author Ben Soones
     */
    val homeVisits: Boolean,

    /**
     * Chosen practice for the appointment.
     * This should default to the doctor's only
     * practice if there's only one, but in instances where
     * a doctor is part of multiple practices, this allows
     * the doctor to choose a suitable one (within range)
     */
    @JoinColumn(name = "${PRACTICE_TABLE_NAME}_id")
    @OneToOne(mappedBy = PRACTICE_TABLE_NAME, cascade = [CascadeType.ALL])
    val appointmentLocation: Practice,

    /**
     * Any special considerations such as accessibility or preferences
     * for religious or other reasons
     */
    val considerations: String,

    /**
     * Chosen appointment date agreed upon between the doctor and patient
     */
    val date: Date?,

    /**
     * Status enum showing the progress of the application
     *
     * @see AppointmentStatus
     */
    val status: AppointmentStatus,

    ) {
    // Base constructor
    constructor() : this(
        0,
        Doctor(),
        mutableSetOf(),
        Pair(0.00, 0.00),
        0.00,
        false,
        Practice(),
        "",
        null,
        AppointmentStatus.SENT
    )
}