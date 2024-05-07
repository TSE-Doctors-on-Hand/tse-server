package cmp2804.tse.server.storage.doctors

import cmp2804.tse.server.storage.practices.Practice
import cmp2804.tse.server.storage.specialties.Speciality
import cmp2804.tse.server.storage.users.User
import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length

const val DOCTOR_TABLE_NAME = "doctors"

/**
 * **Doctors table**
 *
 * Stores all information about a doctor.
 *
 * This table has a relation to a [User]
 *
 * @see [User]
 * @author Ben Soones
 */
@Entity
@Table(name = DOCTOR_TABLE_NAME)
data class Doctor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    /**
     * The doctor's speciality
     *
     * This is something set by the doctor to provide more context
     * towards what service they can provide
     *
     * Example: "Infectious Diseases"
     */
    @ManyToMany
    @NotNull(message = "Speciality cannot be null")
    @NotEmpty(message = "A doctor must have at least one speciality!")
    val specialties: MutableSet<@Valid Speciality>,

    /**
     * An about me of the doctor
     *
     * This can contain any information such as qualifications, experience, etc.
     */
    @Column(length = 4000)
    @Length(max = 4000, message = "About me section must be less than 4,000 characters")
    val aboutMe: String,

    /**
     * Corresponding user
     * @see [User]
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    @NotNull(message = "User cannot be null")
    @Valid
    val user: User,

    /**
     * List of practices the doctor operates in
     *
     * This is usually just one practice, but edge cases of
     * part-time doctors or managers working at multiple practices
     * are supported
     * @see [Practice]
     */
    @ManyToMany(mappedBy = "doctors", cascade = [CascadeType.ALL])
    @NotNull(message = "Practice cannot be null")
    @NotEmpty(message = "Practice cannot be empty")
    val practices: MutableSet<@Valid Practice>,
) {
    constructor() : this(
        null,
        mutableSetOf(),
        "",
        User(),
        mutableSetOf(),
    )
}