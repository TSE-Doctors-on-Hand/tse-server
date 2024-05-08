package cmp2804.tse.server.storage.specialties

import cmp2804.tse.server.storage.doctors.Doctor
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.users.User
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length

const val SPECIALTIES_TABLE_NAME = "specialties"

/**
 * **specialties table**
 *
 * Stores all information about a doctor.
 *
 * This table has a relation to a [User]
 *
 * @see [User]
 * @author Ben Soones
 */
@Entity
@Table(name = SPECIALTIES_TABLE_NAME)
data class Speciality(
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
    @Column(length = 256, unique = true)
    @Length(max = 256, message = "Speciality must be less than 256 characters")
    @NotNull(message = "Speciality cannot be null")
    val name: String,

    /**
     * List of symptoms the doctor can treat for
     *
     * This is used in the matching process, where symptoms are matched up
     * to the doctor who has the highest support rating for them
     *
     * @see [Symptom]
     */
    @ManyToMany
    @NotNull(message = "Symptoms cannot be null")
    @NotEmpty(message = "Symptoms cannot be empty")
    @JsonManagedReference
    val symptoms: MutableSet<@Valid Symptom>,

    @ManyToMany(mappedBy = "specialties", cascade = [CascadeType.ALL])
    @NotNull(message = "Doctors cannot be null")
    @JsonBackReference
    val doctors: MutableSet<@Valid Doctor>,

) {
    constructor() : this(
        null,
        "",
        mutableSetOf(),
        mutableSetOf()
    )

    override fun hashCode(): Int {
        return this.id?.toInt()!!
    }

    override fun toString(): String {
        return ""
    }

}