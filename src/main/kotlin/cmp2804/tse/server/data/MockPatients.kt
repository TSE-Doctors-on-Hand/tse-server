package cmp2804.tse.server.data

import cmp2804.tse.server.storage.patients.Patient

/**
 * Example data for Patients
 *
 * This data is used for testing and examination purposes.
 *
 * In a live example, this data would not be included
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */

val PATIENT_BARRY = Patient(
    null,
    USER_BARRY
)
val PATIENT_VINCENT = Patient(
    null,
    USER_VINCENT
)


val MOCK_PATIENTS = listOf(
    PATIENT_BARRY,
    PATIENT_VINCENT
)
