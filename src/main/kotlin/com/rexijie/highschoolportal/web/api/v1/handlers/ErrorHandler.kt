package com.rexijie.highschoolportal.web.api.v1.handlers

import com.rexijie.highschoolportal.exception.InvalidPathException
import com.rexijie.highschoolportal.exception.NotFoundException
import com.rexijie.highschoolportal.model.ErrorResponse
import org.springframework.http.CacheControl
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

class ErrorHandler(private val request: ServerRequest) {
    fun handleError(throwable: Throwable): Mono<ServerResponse> {
        if (throwable is NotFoundException) return handleStudentNotFound()
        if (throwable is InvalidPathException) return handleInvalidPathInRequest(throwable)


        return ServerResponse.badRequest().build()
    }

    private fun handleStudentNotFound(): Mono<ServerResponse> {
        return ServerResponse
                .notFound()
                .cacheControl(CacheControl.noCache())
                .build()
    }

    private fun handleInvalidPathInRequest(throwable: Throwable): Mono<ServerResponse> {
        return ServerResponse.badRequest()
                .body(Mono.just(ErrorResponse(error = "BAD REQUEST", path = request.path(), message = throwable.message!!, reason = "error in request path")))
    }
}

