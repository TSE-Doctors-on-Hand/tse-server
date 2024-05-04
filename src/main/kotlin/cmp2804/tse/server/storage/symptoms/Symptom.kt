package cmp2804.tse.server.storage.symptoms

import cmp2804.tse.server.storage.doctors.Doctor
import jakarta.persistence.*
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

const val SYMPTOM_TABLE_NAME = "symptoms"

/**
 * **Symptoms table**
 *
 * Stores all information about a practice
 *
 * @author Ben Soones
 */
@Entity
@Table(name = SYMPTOM_TABLE_NAME)
data class Symptom(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    /**
     * Name of the symptom
     *
     * E.g "Headache"
     */
    @Column(unique = true)
    @NotNull
    val name: String,

    @ManyToMany
    @JoinColumn(name = "doctor_id")
    @NotNull
    var doctors: Set<@Valid Doctor>
) {

    constructor() : this(
        null,
        "",
        setOf()

    )
}