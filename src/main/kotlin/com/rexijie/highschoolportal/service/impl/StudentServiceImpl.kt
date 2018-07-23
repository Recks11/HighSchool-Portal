package com.rexijie.highschoolportal.service.impl

import com.rexijie.highschoolportal.exception.NotFoundException
import com.rexijie.highschoolportal.model.Score
import com.rexijie.highschoolportal.model.Student
import com.rexijie.highschoolportal.repository.StudentRepository
import com.rexijie.highschoolportal.service.StudentService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {
    override fun getAllStudents(): Flux<Student> {
        return studentRepository.findAll()
    }

    override fun getStudentById(id: String): Mono<Student> {
        return studentRepository.findById(id)
                .switchIfEmpty(Mono.error(NotFoundException("Student not Found")))
    }

    override fun saveStudent(student: Student): Mono<Student> {
        return studentRepository.save(student)
    }

    override fun getScoresForStudent(id: String): Flux<Score> {
        return getStudentById(id).flatMapIterable { it.scores }
    }

    override fun getScoresForStudentInSession(id: String, session: String): Flux<Score> {
        return getStudentById(id).flatMapIterable {
            it.scores
        }.filter {
            it.session.toUpperCase() == session.toUpperCase()
        }.switchIfEmpty(Mono.error(NotFoundException("Results For Session Not Found")))
    }
}