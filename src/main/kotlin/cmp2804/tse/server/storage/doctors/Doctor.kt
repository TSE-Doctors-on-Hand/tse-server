package cmp2804.tse.server.storage.doctors

import cmp2804.tse.server.storage.practices.PRACTICE_TABLE_NAME
import cmp2804.tse.server.storage.practices.Practice
import cmp2804.tse.server.storage.symptoms.SYMPTOM_TABLE_NAME
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.users.USER_TABLE_NAME
import cmp2804.tse.server.storage.users.User
import jakarta.persistence.*

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
    val speciality: String,

    /**
     * An about me of the doctor
     *
     * This can contain any information such as qualifications, experience, etc.
     */
    val aboutMe: String,

    /**
     * Corresponding user
     * @see [User]
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
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
    val practices: MutableSet<Practice>,

    /**
     * List of symptoms the doctor can treat for
     *
     * This is used in the matching process, where symptoms are matched up
     * to the doctor who has the highest support rating for them
     *
     * @see [Symptom]
     * @see [Doctor]
     */
    @ManyToMany(mappedBy = "doctors", cascade = [CascadeType.ALL])
    val symptoms: MutableSet<Symptom>
) {
    constructor() : this(
        null,
        "",
        "",
        User(),
        mutableSetOf(),
        mutableSetOf()
    )
}