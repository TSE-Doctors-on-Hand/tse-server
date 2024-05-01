package cmp2804.tse.server.storage.patients

import cmp2804.tse.server.storage.users.USER_TABLE_NAME
import cmp2804.tse.server.storage.users.User
import javax.persistence.*

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
    @JoinColumn(name = "${USER_TABLE_NAME}_id")
    @OneToOne(mappedBy = USER_TABLE_NAME, cascade = [CascadeType.ALL])
    val user: User,

    /**
     * Carer(s) information
     *
     * Some users using this service may be vulnerable and require care, such as
     * Children, SEN users, and the elderly
     *
     * A single patient may have multiple carers, such as care home staff or parents
     *
     * @see [User]
     */
    @JoinColumn(name = "${USER_TABLE_NAME}_id")
    @OneToMany(mappedBy = USER_TABLE_NAME, cascade = [CascadeType.ALL])
    val carers: MutableList<User>,

    )