package com.rexijie.highschoolportal.service.impl

import com.rexijie.highschoolportal.model.Subject
import com.rexijie.highschoolportal.repository.SubjectRepository
import com.rexijie.highschoolportal.service.SubjectService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SubjectServiceImpl(private val subjectRepository: SubjectRepository) : SubjectService {
    override fun findSubjectById(id: String): Mono<Subject> = subjectRepository.findById(id)
}