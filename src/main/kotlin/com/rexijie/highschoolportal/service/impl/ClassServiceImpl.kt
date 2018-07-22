package com.rexijie.highschoolportal.service.impl

import com.rexijie.highschoolportal.model.HighSchoolClass
import com.rexijie.highschoolportal.repository.ClassRepository
import com.rexijie.highschoolportal.service.ClassService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ClassServiceImpl(private val classRepository: ClassRepository) : ClassService {
    override fun findAllClasses(): Flux<HighSchoolClass> = classRepository.findAll()
    override fun findClassById(id: String) = classRepository.findById(id)
}