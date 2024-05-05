package cmp2804.tse.server

import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.practices.Practice
import cmp2804.tse.server.storage.roles.Role
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import org.springframework.boot.test.context.TestConfiguration

@TestConfiguration
class TestMocks {
    companion object {
        val PATIENT_ROLE: Role = Role(1L, RolesEnum.PATIENT, setOf())
        val DOCTOR_ROLE: Role = Role(2L, RolesEnum.DOCTOR, setOf())

        val PATIENT_USER: User = User(
            1L,
            "username",
            "password",
            "forename",
            "surname",
            1000L,
            SexEnum.MALE,
            mutableListOf("he/him"),
            "test@example.com",
            "07000000000",
            0.0,
            0.0,
            "Next of kin",
            setOf(PATIENT_ROLE)
        )

        val DOCTOR_USER: User = User(
            2L,
            "doctor",
            "password",
            "forename",
            "surname",
            1000L,
            SexEnum.MALE,
            mutableListOf("he/him"),
            "doctor@example.com",
            "07000000001",
            0.0,
            0.0,
            "Next of kin",
            setOf(DOCTOR_ROLE)
        )

        val PATIENT: Patient = Patient(
            1L,
            PATIENT_USER
        )
        val PRACTICE: Practice = Practice(
            1L,
            "Example practice",
            0.00,
            0.00,
            "Example address",
            setOf()
        )
        val SYMPTOM: Symptom = Symptom(
            1L,
            "Example Symptom",
            setOf()
        )
        val DOCTOR: Doctor = Doctor(
            1L,
            "Infectious Diseases",
            "Example about me section",
            DOCTOR_USER,
            mutableSetOf(PRACTICE),
            mutableSetOf(SYMPTOM)
        )

        val APPOINTMENT: Appointment = Appointment(
            1L,
            PATIENT,
            DOCTOR,
            mutableSetOf(1L),
            0.00,
            0.00,
            1.00,
            false,
            null,
            null,
            null,
            1
        )

        val APPOINTMENTS: List<Appointment> = listOf(APPOINTMENT)
    }
}



