package cmp2804.tse.server.storage.roles

import cmp2804.tse.server.storage.users.User
import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

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
    @NotNull
    val name: RolesEnum,

    @ManyToMany
    @JoinColumn(name = "user_id")
    @NotNull
    var users: Set<@Valid User>
) {
    constructor() : this(
        null,
        RolesEnum.PATIENT,
        setOf()
    )
}