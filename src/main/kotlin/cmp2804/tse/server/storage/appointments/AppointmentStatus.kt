package cmp2804.tse.server.storage.appointments


/**
 * **Appointment Status Enum**
 *
 * Possible stages of an appointment
 * @see [Appointment]
 * @author Ben Soones
 */
enum class AppointmentStatus {
    /**
     * Appointment request has been completed by a patient
     * and is in the corresponding doctor's inbox
     *
     * @see cmp2804.tse.server.storage.doctors.Doctor
     */
    SENT,

    /**
     * The request has been opened by the doctor
     */
    SEEN,

    /**
     * The request has been reviewed by the doctor,
     * and the doctor is now working on an appointment
     * date and practice
     */
    REVIEWED,

    /**
     * A suggested date and practice has been offered
     * to the patient, and is awaiting confirmation
     *
     * **NOTE: If a patient denies this stage, the status will
     * return to [REVIEWED]**
     */
    AWAITING_CONFIRMATION,

    /**
     * The appointment has been confirmed by both the doctor and the patient
     */
    CONFIRMED,

    /**
     * The patient has attended the appointment, marking this appointment as complete
     *
     * **NOTE: If a patient misses their appointment, the status will return to [REVIEWED]**
     */
    COMPLETE,

    /**
     * The appointment has been cancelled, no further actions should be taken.
     *
     * This appointment can be cancelled at any time, by either the doctor or the patient
     *
     * **NOTE: If the appointment is cancelled by the doctor, a reason must be given**
     */
    CANCELLED
}