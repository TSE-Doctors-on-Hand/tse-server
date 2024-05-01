package cmp2804.tse.server.util.request

import cmp2804.tse.server.storage.users.SexEnum

data class SignUpRequest(
    val username: String,
    val password: String,
    val forename: String,
    val surname: String,
    val dateOfBirth: Long,
    val sex: SexEnum,
    val pronouns: MutableList<String>,
    val email: String,
    val phone: String?,
    val homeLocationLat: Double,
    val homeLocationLong: Double,
    val nextOfKin: String
    ) {}