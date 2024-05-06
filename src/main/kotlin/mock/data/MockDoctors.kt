package mock.data

import cmp2804.tse.server.storage.doctors.Doctor
import mock.data.symptom.MockSpecialties


val DOCTOR_THOMAS = Doctor(
    null,
    mutableSetOf(
        MockSpecialties.CARDIOLOGY,
        ),
    "",
    USER_THOMAS,
    mutableSetOf(
        PRACTICE_NEWLAND
    ),
)

val DOCTOR_JOHNNY = Doctor(
    null,
    mutableSetOf(
        MockSpecialties.GYNECOLOGY
    ),
    "My name is Dr Johnny Sins (PHD).\n " +
            "I am the best Doctor in the world!\n\n" +
            "I also have experience in plumbing, teaching, babysitting and more!",
    USER_JOHNNY,
    mutableSetOf(
        PRACTICE_STUDENT
    ),
)










