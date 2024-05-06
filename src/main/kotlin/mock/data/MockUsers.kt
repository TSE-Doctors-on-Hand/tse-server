package mock.data

import cmp2804.tse.server.storage.users.SexEnum
import cmp2804.tse.server.storage.users.User
import java.sql.Date

val USER_BARRY = User(
    null,
    "brexit",
    "\$2a\$12\$92N4AVWezr4aqjUFTmupkOGG5dBqnVM6.QCj7Lr3SNQof9De.Vgj6", // BREXIT
    "Barry",
    "Johnson",
    Date(1962, 4, 23),
    SexEnum.MALE,
    mutableListOf("brexit/geezer"),
    "barry62@geezermail.com",
    "07000000000",
    51.41142516664304,
    -0.30055887976455625,
    "Sandra",
    setOf(MOCK_PATIENT_ROLE),
)
val USER_VINCENT = User(
    null,
    "vincent",
    "\$2a\$12\$i7zNIdkHFg3p0OkEZX2orOwcqSVWWKI1q2pTOKoPouKgn24aZtwJq", // Unappreciated
    "Vincent",
    "van Gogh",
    Date(1853, 3, 30),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "vincent@gmail.com",
    "07000000001",
    51.470009190766746,
    4.661027886598867,
    "Amy Pond",
    setOf(MOCK_PATIENT_ROLE),
)

val USER_JOHNNY = User(
    null,
    "jackeroftrades",
    "\$2a\$12\$st7OJH2NxZuYp72M5wW5ResP4iudMN78E4GMMfMCPsKLQlqbhFwgC", // Plumber
    "Johnny",
    "Sins",
    Date(1980, 9, 28),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "johnny@gmail.com",
    "07000000002",
    78.22268119015065,
    15.651867807128172,
    "Innumerable",
    setOf(MOCK_DOCTOR_ROLE),
)

val USER_THOMAS = User(
    null,
    "thomas",
    "\$2a\$12$\\xjAwXQX8pCPF8TS4OZJ16.os5Jpdk777JU/XGXjWbTWzTYuVTa0sy", // Pathological
    "Thomas",
    "Higgins",
    Date(2000, 11, 30),
    SexEnum.MALE,
    mutableListOf("he/him"),
    "thomas@gmail.com",
    "07000000003",
    53.22994562194274,
    -0.5476375217330632,
    "Johnny",
    setOf(MOCK_DOCTOR_ROLE),
)


val MOCK_USERS = listOf(
    USER_BARRY,
    USER_VINCENT,
    USER_JOHNNY,
    USER_THOMAS
)
