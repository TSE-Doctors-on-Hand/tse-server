package cmp2804.tse.server

import cmp2804.tse.server.storage.appointments.Appointment
import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.patients.Patient
import cmp2804.tse.server.storage.practices.Practice
import cmp2804.tse.server.storage.roles.RolesEnum
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import org.springframework.boot.test.context.TestConfiguration
import java.sql.Date

@TestConfiguration
class TestMocks {
    companion object {

        val PATIENT_USER: User = User(
            1L,
            "username",
            "password",
            "forename",
            "surname",
            Date(2000,1,1),
            SexEnum.MALE,
            mutableListOf("he/him"),
            "test@example.com",
            "07000000000",
            0.0,
            0.0,
            "Next of kin",
            mutableSetOf(RolesEnum.PATIENT)
        )

        val DOCTOR_USER: User = User(
            2L,
            "doctor",
            "password",
            "forename",
            "surname",
            Date(2000,1,1),
            SexEnum.MALE,
            mutableListOf("he/him"),
            "doctor@example.com",
            "07000000001",
            0.0,
            0.0,
            "Next of kin",
            mutableSetOf(RolesEnum.DOCTOR)
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
            mutableSetOf(), // TODO -> Add specialty
            "Example about me section",
            DOCTOR_USER,
            mutableSetOf(PRACTICE)
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



