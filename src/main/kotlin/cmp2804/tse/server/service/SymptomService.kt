package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.symptoms.SYMPTOMS
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.symptoms.SymptomsRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

/**
 * Symptom service
 *
 * This service is responsible for all functions interacting with symptoms
 *
 * @author Ben Soones
 * @author Oliver Whitehead
 */
@Service
class SymptomService(
    private val symptomsRepository: SymptomsRepository
): BaseService<Symptom, Long> {

    /**
     * Retrieve all symptoms. This is not a protected endpoint
     *
     * @return List of [Symptom]
     */
    fun getAllSymptoms(): List<Symptom> {
        return symptomsRepository.findAll()
    }

    /**
     * Retrieves a list of symptoms by their IDs
     *
     * @param ids List of IDs
     *
     * @return List of [Symptom] that match [ids]
     */
    fun getSymptomsByIds(ids: Set<Long>): Set<Symptom> {
        return getAllSymptoms().filter {
            ids.contains(it.id )
        }.toSet()
    }

    /**
     * Inserts all mock symptoms, This function will not be used in the live version
     */
    fun insertAllSymptoms(): Boolean {
        try {
            SYMPTOMS.forEach {symptom ->
                if (symptomsRepository.findByName(symptom) != null) return@forEach

                val newSymptom = Symptom(
                    id = null,
                    name = symptom,
                    setOf()
                )
                newSymptom.let { symptomsRepository.save(it) }
            }
            return true
        } catch (e: Exception) {
            return false
        }
    }


    override fun getRepository(): JpaRepository<Symptom, Long> = symptomsRepository

}