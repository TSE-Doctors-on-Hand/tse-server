package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.symptoms.SYMPTOMS
import cmp2804.tse.server.storage.symptoms.Symptom
import cmp2804.tse.server.storage.symptoms.SymptomsRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class SymptomService(
    private val symptomsRepository: SymptomsRepository
): BaseService<Symptom, Long> {

    fun getAllSymptoms(): List<Symptom> {
        return symptomsRepository.findAll()
    }

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