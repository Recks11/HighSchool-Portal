package com.rexijie.highschoolportal.service.impl

import com.rexijie.highschoolportal.model.Subject
import com.rexijie.highschoolportal.model.enums.Level
import com.rexijie.highschoolportal.repository.SubjectRepository
import com.rexijie.highschoolportal.service.SubjectService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class SubjectServiceImpl(private val subjectRepository: SubjectRepository) : SubjectService {
    override fun findSubjectById(id: String): Mono<Subject> = subjectRepository.findById(id)
    override fun findSeniorSubjects(): Flux<Subject> = subjectRepository.findSubjectsByLevelEquals(Level.SENIOR)
    override fun findJuniorSubjects(): Flux<Subject> = subjectRepository.findSubjectsByLevelEquals(Level.JUNIOR)
}