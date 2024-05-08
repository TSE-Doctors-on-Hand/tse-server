package cmp2804.tse.server.storage.patients

import cmp2804.tse.server.storage.users.USER_TABLE_NAME
import cmp2804.tse.server.storage.users.User
import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

const val PATIENT_TABLE_NAME = "patients"

/**
 * **Patients table**
 *
 * Stores all information about a patient
 *
 * This table has a relation to a [User]
 *
 * @see [User]
 * @author Ben Soones
 */
@Entity
@Table(name = PATIENT_TABLE_NAME)
data class Patient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    /**
     * Corresponding user
     * @see [User]
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    @NotNull(message = "User cannot be null")
    @Valid
    val user: User,

    ) {
    constructor() : this(
        null,
        User(),
//        mutableSetOf(),
    )
}