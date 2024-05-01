package cmp2804.tse.server.util.request

import cmp2804.tse.server.storage.users.SexEnum
import java.sql.Date


data class SignUpRequest(
    val username: String,
    val password: String,
    val forename: String,
    val surname: String,
    val dateOfBirth: Date,
    val sex: SexEnum,
    val pronouns: MutableList<String>,
    val email: String,
    val phone: String?,
    val homeLocationLat: Double,
    val homeLocationLong: Double,
    val nextOfKin: String
    ) {}