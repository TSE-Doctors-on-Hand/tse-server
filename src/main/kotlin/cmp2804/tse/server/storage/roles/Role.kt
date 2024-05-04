package cmp2804.tse.server.storage.roles

import cmp2804.tse.server.storage.practices.PRACTICE_TABLE_NAME
import cmp2804.tse.server.storage.practices.Practice
import cmp2804.tse.server.storage.symptoms.SYMPTOM_TABLE_NAME
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.users.USER_TABLE_NAME
import cmp2804.tse.server.storage.users.User
import javax.persistence.*

const val ROLE_TABLE_NAME = "roles"

/**
 * **Roles table**
 *
 * Stores all information about a doctor.
 *
 * This table has a relation to a [User]
 *
 * @see [User]
 * @author Ben Soones
 */
@Entity
@Table(name = ROLE_TABLE_NAME)
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(length = 7) // Patient - 7 chars
    val name: RolesEnum
)