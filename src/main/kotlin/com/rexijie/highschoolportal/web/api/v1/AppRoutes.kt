package com.rexijie.highschoolportal.web.api.v1

import com.rexijie.highschoolportal.web.api.v1.handlers.ErrorHandler
import com.rexijie.highschoolportal.web.api.v1.handlers.ScoreHandler
import com.rexijie.highschoolportal.web.api.v1.handlers.StudentHandler
import com.rexijie.highschoolportal.web.api.v1.handlers.TeacherHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class AppRoutes(private val studentHandler: StudentHandler,
                private val scoreHandler: ScoreHandler,
                private val teacherHandler: TeacherHandler) {

    @Bean
    fun applicationRoutes(): RouterFunction<ServerResponse> {
        return router {
            ("/api/v1" and accept(MediaType.APPLICATION_JSON)).nest {
                ("/student").nest {
                    GET("/", studentHandler::getAllStudents)
                    POST("/", studentHandler::saveStudent)
                    GET("/{id}", studentHandler::getStudentByID)
                    GET("/{id}/scores", studentHandler::getScoresForStudent)
                    GET("/{id}/scores/{session}", studentHandler::getStudentScoresForSession)
                }
                ("/scores").nest {
                    GET("/{scoreId}", scoreHandler::getScoreById)
                    POST("/{scoreId}", scoreHandler::updateStudentScore)
                }
                ("/teacher" and accept(MediaType.APPLICATION_JSON)).nest {
                    GET("/", teacherHandler::getAllTeachers)
                    GET("/{id}", teacherHandler::findTeacherById)
                    GET("/{id}/subjects", teacherHandler::getAllSubjects)
                }
            }
        }.filter { //Error Handling using a filter
            request, next -> next.handle(request)
                .onErrorResume {
                    ErrorHandler(request).handleError(it)
                }
        }
    }
}