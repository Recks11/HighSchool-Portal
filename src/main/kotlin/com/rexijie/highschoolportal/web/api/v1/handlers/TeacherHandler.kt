package com.rexijie.highschoolportal.web.api.v1.handlers

import com.rexijie.highschoolportal.service.TeacherService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Component
class TeacherHandler(private val teacherService: TeacherService) {

    fun getAllTeachers(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
                .ok()
                .body(teacherService.getAllTeachers())
    }

    fun findTeacherById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        return ServerResponse
                .ok()
                .body(teacherService.getTeacherById(id))
    }

    fun getAllSubjects(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id")
        return ServerResponse
                .ok()
                .body(teacherService.getSubjectsForTeacher(id).switchIfEmpty {
            Mono.error<ResponseStatusException>(ResponseStatusException(HttpStatus.NO_CONTENT, "Teacher teaches no subjects 🤔"))
        })
    }
}