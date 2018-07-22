package com.rexijie.highschoolportal.web.api.v1.handlers

import com.rexijie.highschoolportal.model.Student
import com.rexijie.highschoolportal.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class StudentHandler(private val studentService: StudentService) {

    fun getAllStudents(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(studentService.getAllStudents())
    }

    fun saveStudent(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono<Student>().flatMap { student ->
            studentService.saveStudent(student).flatMap {

                ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(it))
            }
        }.doOnError { t: Throwable? ->
            t?.printStackTrace()
        }
    }

    fun getStudentByID(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        return studentService.getStudentById(id).flatMap {
            ServerResponse.ok().body(Mono.just(it))
        }
    }
}