package com.rexijie.highschoolportal.service

import com.rexijie.highschoolportal.model.Student
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface StudentService {
    fun getAllStudents(): Flux<Student>
    fun getStudentById(id: String): Mono<Student>
    fun saveStudent(student: Student): Mono<Student>
}