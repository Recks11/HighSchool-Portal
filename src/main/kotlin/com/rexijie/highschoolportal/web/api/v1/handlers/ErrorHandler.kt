package com.rexijie.highschoolportal.web.api.v1.handlers

import com.rexijie.highschoolportal.exception.NotFoundException
import org.springframework.http.CacheControl
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

class ErrorHandler {
    fun handleError(throwable: Throwable): Mono<ServerResponse> {
        if (throwable is NotFoundException) {
            return handleStudentNotFound()
        }

        return ServerResponse.badRequest().build()
    }

    fun handleStudentNotFound(): Mono<ServerResponse> {
        return ServerResponse
                .noContent()
                .cacheControl(CacheControl.noCache())
                .build()
    }
}