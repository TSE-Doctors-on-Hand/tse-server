package cmp2804.tse.server.storage

import java.sql.Date
import javax.persistence.*

const val USER_TABLE_NAME = "users"

@Entity
@Table(name = USER_TABLE_NAME)
data class User(
    @Id
    @GeneratedValue
    val id: Long,

    val forename: String,
    val surname: String,

    val dateOfBirth: Date,
    val sex: Boolean, // True for male, false for female

    @ElementCollection
    val pronouns: MutableList<String>,

    val email: String,
    val phone: String,
    val homeLocation: Pair<Double, Double>, // Lat long coords
    val nextOfKin: String
) {
    constructor() : this(0,"","",Date(0),true, mutableListOf(),"","",Pair(0.00,0.00),"")
}