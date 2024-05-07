package cmp2804.tse.server.storage.appointments

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.practices.Practice
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.users.User
import cmp2804.tse.server.storage.validators.futuretimestamp.FutureTimestamp
import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.Range

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    /**
     * Appointment patient:
     *
     * The patient connected to an appointment
     *
     * @see Patient
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Patient cannot be null")
    @Valid
    val patient: Patient,

    /**
     * Appointment doctor:
     *
     * The doctor selected to handle an appointment
     *
     * @see Doctor
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "doctor_id")
    @NotNull(message = "Doctor cannot be null")
    @Valid
    val doctor: Doctor,

    /**
     * Patient chosen list of available dates
     */
    @ElementCollection
    var availableDates: MutableSet<@FutureTimestamp(message = "Each timestamp must be in the future") Long>,

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
    @DecimalMin("-90.00")
    @DecimalMax("90.00")
    @NotNull(message = "Home location cannot be null")
    val homeLocationLat: Double,

    @DecimalMin("-180.00")
    @DecimalMax("180.00")
    @NotNull(message = "Home location cannot be null")
    val homeLocationLong: Double,

    /**
     * Acceptable range
     *
     * Extra information for doctors to use to recommend another
     * doctor / practice
     *
     * **NOTE: THE RANGE IS IN MILES**
     */
    @PositiveOrZero(message = "Range must be greater than 0 km")
    @NotNull(message = "Range cannot be null")
    val range: Double,

    /**
     * Accessibility feature: Allow for home visits just like the NHS
     */
    @NotNull(message = "Home visits option cannot be null")
    val homeVisits: Boolean,

    /**
     * Chosen practice for the appointment.
     * This should default to the doctor's only
     * practice if there's only one, but in instances where
     * a doctor is part of multiple practices, this allows
     * the doctor to choose a suitable one (within range)
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "practice_id")
    @Valid
    val appointmentLocation: Practice?,

    /**
     * Any special considerations such as accessibility or preferences
     * for religious or other reasons
     */
    @Column(length = 4000)
    @Length(max = 4000, message = "Considerations must be less than 4000 characters")
    val considerations: String?,

    /**
     * Chosen appointment date upon between the doctor and patient
     */
    @FutureTimestamp("The appointment date must be in the future")
    var date: Long?,

    /**
     * Status enum value showing the progress of the application
     *
     * @see AppointmentStatus
     */
    @Range(min = 0, max = 6, message = "The status must be between 0 and 6")
    @NotNull(message = "Status cannot be null")
    var status: Int,

    ) {
    constructor() : this(
        null,
        Patient(),
        Doctor(),
        mutableSetOf(),
        0.0,
        0.0,
        0.0,
        false,
        Practice(),
        "",
        0L,
        0
    )

    fun hasViewPermission(user: User): Boolean {
        return hasPatientPermission(user) || hasDoctorPermission(user)
    }

    fun hasPatientPermission(user: User): Boolean {
        if (hasAdminPermission(user)) return true
        return (this.patient.user.id == user.id)

    }

    fun hasDoctorPermission(user: User): Boolean {
        if (hasAdminPermission(user)) return true
        return (this.doctor.user.id == user.id)
    }

    fun hasAdminPermission(user: User): Boolean {
        return user.getHighestRole() == RolesEnum.ADMIN
    }

}