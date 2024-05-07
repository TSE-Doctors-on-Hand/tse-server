package mock.data

import cmp2804.tse.server.storage.doctors.Doctor
import mock.data.symptom.MockSpecialties


val DOCTOR_CHARLIE = Doctor(
    null,
    mutableSetOf(MockSpecialties.CARDIOLOGY),
    "Example About me",
    USER_CHARLIE,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_OLIVIA = Doctor(
    null,
    mutableSetOf(MockSpecialties.ONCOLOGY),
    "Example About me",
    USER_OLIVIA,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_JACK = Doctor(
    null,
    mutableSetOf(MockSpecialties.GASTROENTEROLOGY),
    "Example About me",
    USER_JACK,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_AMELIA = Doctor(
    null,
    mutableSetOf(MockSpecialties.PULMONOLOGY),
    "Example About me",
    USER_AMELIA,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_GEORGE = Doctor(
    null,
    mutableSetOf(MockSpecialties.GYNECOLOGY),
    "Example About me",
    USER_GEORGE,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_EMILY = Doctor(
    null,
    mutableSetOf(MockSpecialties.NEUROLOGY),
    "Example About me",
    USER_EMILY,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_WILLIAM = Doctor(
    null,
    mutableSetOf(MockSpecialties.DERMATOLOGY),
    "Example About me",
    USER_WILLIAM,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_LILY = Doctor(
    null,
    mutableSetOf(MockSpecialties.RHEUMATOLOGY),
    "Example About me",
    USER_LILY,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_HENRY = Doctor(
    null,
    mutableSetOf(MockSpecialties.UROLOGY),
    "Example About me",
    USER_HENRY,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_CHLOE = Doctor(
    null,
    mutableSetOf(MockSpecialties.OTOLARYNGOLOGY),
    "Example About me",
    USER_CHLOE,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_DANIEL = Doctor(
    null,
    mutableSetOf(MockSpecialties.ORTHOPEDICS),
    "Example About me",
    USER_DANIEL,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_ISABELLA = Doctor(
    null,
    mutableSetOf(MockSpecialties.PSYCHIATRY),
    "Example About me",
    USER_ISABELLA,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_JOSEPH = Doctor(
    null,
    mutableSetOf(MockSpecialties.ENDOCRINOLOGY),
    "Example About me",
    USER_JOSEPH,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_SOPHIE = Doctor(
    null,
    mutableSetOf(MockSpecialties.IMMUNOLOGY),
    "Example About me",
    USER_SOPHIE,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_HARRY = Doctor(
    null,
    mutableSetOf(MockSpecialties.OPHTHALMOLOGY),
    "Example About me",
    USER_HARRY,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_GRACE = Doctor(
    null,
    mutableSetOf(MockSpecialties.HEMATOLOGY),
    "Example About me",
    USER_GRACE,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_JAMES = Doctor(
    null,
    mutableSetOf(MockSpecialties.INFECTIOUS_DISEASES),
    "Example About me",
    USER_JAMES,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_MIA = Doctor(
    null,
    mutableSetOf(MockSpecialties.NEPHROLOGY),
    "Example About me",
    USER_MIA,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_JOSEF = Doctor(
    null,
    mutableSetOf(MockSpecialties.NEONATOLOGY),
    "Example About me",
    USER_JOSEF,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_RUBY = Doctor(
    null,
    mutableSetOf(MockSpecialties.GERIATRICS),
    "Example About me",
    USER_RUBY,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_CHARLY = Doctor(
    null,
    mutableSetOf(MockSpecialties.PAIN_MANAGEMENT),
    "Example About me",
    USER_CHARLY,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_POPPY = Doctor(
    null,
    mutableSetOf(MockSpecialties.PEDIATRICS),
    "Example About me",
    USER_POPPY,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_HAROLD = Doctor(
    null,
    mutableSetOf(MockSpecialties.PLASTIC_SURGERY),
    "Example About me",
    USER_HAROLD,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_EVIE = Doctor(
    null,
    mutableSetOf(MockSpecialties.PROCTOLOGY),
    "Example About me",
    USER_EVIE,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_LEO = Doctor(
    null,
    mutableSetOf(MockSpecialties.SEXOLOGY),
    "Example About me", USER_LEO,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_DAISY = Doctor(
    null,
    mutableSetOf(MockSpecialties.SLEEP_MEDICINE),
    "Example About me",
    USER_DAISY,
    mutableSetOf(PRACTICE_CLIFF)
)
val DOCTOR_OSCAR = Doctor(
    null,
    mutableSetOf(MockSpecialties.GENERAL_PRACTICE),
    "Example About me",
    USER_OSCAR,
    mutableSetOf(PRACTICE_STUDENT)
)
val DOCTOR_LEAH = Doctor(
    null,
    mutableSetOf(MockSpecialties.SPORTS_MEDICINE),
    "Example About me",
    USER_LEAH,
    mutableSetOf(PRACTICE_NEWLAND)
)
val DOCTOR_OLIVER = Doctor(
    null,
    mutableSetOf(MockSpecialties.THERAPY),
    "Example About me",
    USER_OLIVER,
    mutableSetOf(PRACTICE_STUDENT)
)

val MOCK_DOCTORS = listOf(
    DOCTOR_CHARLIE,
    DOCTOR_OLIVIA,
    DOCTOR_JACK,
    DOCTOR_AMELIA,
    DOCTOR_GEORGE,
    DOCTOR_EMILY,
    DOCTOR_WILLIAM,
    DOCTOR_LILY,
    DOCTOR_HENRY,
    DOCTOR_CHLOE,
    DOCTOR_DANIEL,
    DOCTOR_ISABELLA,
    DOCTOR_JOSEPH,
    DOCTOR_SOPHIE,
    DOCTOR_HARRY,
    DOCTOR_GRACE,
    DOCTOR_JAMES,
    DOCTOR_MIA,
    DOCTOR_JOSEF,
    DOCTOR_RUBY,
    DOCTOR_CHARLY,
    DOCTOR_POPPY,
    DOCTOR_HAROLD,
    DOCTOR_EVIE,
    DOCTOR_LEO,
    DOCTOR_DAISY,
    DOCTOR_OSCAR,
    DOCTOR_LEAH,
    DOCTOR_OLIVER,
)










