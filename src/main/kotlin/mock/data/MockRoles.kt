package mock.data

import cmp2804.tse.server.storage.roles.Role
import cmp2804.tse.server.storage.roles.RolesEnum


val MOCK_PATIENT_ROLE = Role(
    1,
    RolesEnum.PATIENT,
    setOf()
)

val MOCK_DOCTOR_ROLE = Role(
    2,
    RolesEnum.DOCTOR,
    setOf()
)

val MOCK_ADMIN_ROLE = Role(
    3,
    RolesEnum.ADMIN,
    setOf()
)