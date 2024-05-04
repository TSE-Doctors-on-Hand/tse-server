package cmp2804.tse.server.util.request

data class SignUpRequest(
    val username: String,
    val password: String,
    val forename: String,
    val surname: String,
    val dateOfBirth: Long,
    val sex: Int,
    val pronouns: MutableList<String>,
    val email: String,
    val phone: String?,
    val homeLocationLat: Double,
    val homeLocationLong: Double,
    val nextOfKin: String
    ) {}