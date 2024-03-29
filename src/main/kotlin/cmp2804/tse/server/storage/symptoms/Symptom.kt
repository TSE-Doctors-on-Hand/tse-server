package cmp2804.tse.server.storage.symptoms

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

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
    @GeneratedValue
    val id: Long,

    /**
     * Name of the symptom
     *
     * E.g "Headache"
     */
    val name: String,
) {
    constructor() : this(0, "")
}