package com.rexijie.highschoolportal.service

import com.rexijie.highschoolportal.model.Subject
import com.rexijie.highschoolportal.model.Teacher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TeacherService {
    fun getAllTeachers(): Flux<Teacher>
    fun saveTeacher(teacher: Teacher): Mono<Teacher>
    fun getTeacherById(id: String): Mono<Teacher>
    fun getSubjectsForTeacher(id: String): Flux<Subject>
}