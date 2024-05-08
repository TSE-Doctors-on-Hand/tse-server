package cmp2804.tse.server.storage.symptoms

import cmp2804.tse.server.storage.specialties.Speciality
import com.fasterxml.jackson.annotation.JsonBackReference
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
    @NotNull(message = "Symptom cannot be null")
    val name: String,

    /**
     * Set of specialties this symptom is in
     */
    @ManyToMany(mappedBy = "symptoms")
    @JsonBackReference
    var specialties: Set<@Valid Speciality>
) {

    constructor() : this(
        null,
        "",
        setOf()

    )
}