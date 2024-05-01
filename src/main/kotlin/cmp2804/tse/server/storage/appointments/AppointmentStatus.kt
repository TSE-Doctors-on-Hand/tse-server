package cmp2804.tse.server.storage.appointments


/**
 * **Appointment Status Enum**
 *
 * Possible stages of an appointment
 * @see [Appointment]
 * @author Ben Soones
 */
enum class AppointmentStatus(val index: Int) {
    /**
     * The appointment has been canceled, no further actions should be taken.
     *
     * This appointment can be canceled at any time, by either the doctor or the patient
     *
     * **NOTE: If the doctor cancels the appointment, a reason must be given**
     */
    CANCELLED(0),


    /**
     * Appointment request has been completed by a patient
     * and is in the corresponding doctor's inbox
     *
     * @see cmp2804.tse.server.storage.doctors.Doctor
     */
    SENT(1),

    /**
     * The request has been opened by the doctor
     */
    SEEN(2),

    /**
     * The request has been reviewed by the doctor,
     * and the doctor is now working on an appointment
     * date and practice
     */
    REVIEWED(3),

    /**
     * A suggested date and practice has been offered
     * to the patient, and is awaiting confirmation
     *
     * **NOTE: If a patient denies this stage, the status will
     * return to [REVIEWED]**
     */
    AWAITING_CONFIRMATION(4),

    /**
     * The appointment has been confirmed by both the doctor and the patient
     */
    CONFIRMED(5),

    /**
     * The patient has attended the appointment, marking this appointment as complete
     *
     * **NOTE: If a patient misses their appointment, the status will return to [REVIEWED]**
     */
    COMPLETE(6);

    fun getByIndex(index: Int): AppointmentStatus? {
        return values().getOrNull(index)
    }

}