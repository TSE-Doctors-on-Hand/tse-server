package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
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

    override fun getRepository(): JpaRepository<Symptom, Long> = symptomsRepository

}