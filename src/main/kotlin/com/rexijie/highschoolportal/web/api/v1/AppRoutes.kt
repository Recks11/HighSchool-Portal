package com.rexijie.highschoolportal.web.api.v1

import com.rexijie.highschoolportal.web.api.v1.handlers.ErrorHandler
import com.rexijie.highschoolportal.web.api.v1.handlers.StudentHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class AppRoutes(private val studentHandler: StudentHandler) {

    @Bean
    fun applicationRoutes(): RouterFunction<ServerResponse> {
        return router {
            ("/api/v1" and accept(MediaType.APPLICATION_JSON)).nest {
                ("/student").nest {
                    GET("/", studentHandler::getAllStudents)
                    POST("/", studentHandler::saveStudent)
                    GET("/{id}", studentHandler::getStudentByID)
                }
            }
        }.filter { //Error Handling using a filter
            request, next -> next.handle(request)
                .onErrorResume {
                    ErrorHandler().handleError(it)
                }
        }
    }
}