package com.rexijie.highschoolportal.service.impl

import com.rexijie.highschoolportal.exception.NotFoundException
import com.rexijie.highschoolportal.model.Subject
import com.rexijie.highschoolportal.model.Teacher
import com.rexijie.highschoolportal.repository.TeacherRepository
import com.rexijie.highschoolportal.service.TeacherService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TeacherServiceImpl(private val teacherRepository: TeacherRepository) : TeacherService {
    override fun getAllTeachers(): Flux<Teacher> {
        return teacherRepository.findAll()
    }
    override fun saveTeacher(teacher: Teacher): Mono<Teacher> = teacherRepository.save(teacher)
            .onErrorResume {
                Mono.error(ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while saving the data"))
            }

    override fun getTeacherById(id: String): Mono<Teacher> = teacherRepository.findById(id)
            .switchIfEmpty(Mono.error(NotFoundException("Teacher not Found")))

    override fun getSubjectsForTeacher(id: String): Flux<Subject> = getTeacherById(id).flatMapIterable { it.subjects }
}