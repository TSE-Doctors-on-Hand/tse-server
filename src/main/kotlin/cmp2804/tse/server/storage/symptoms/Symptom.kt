package cmp2804.tse.server.storage.symptoms

import javax.persistence.*

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
    val name: String,
)