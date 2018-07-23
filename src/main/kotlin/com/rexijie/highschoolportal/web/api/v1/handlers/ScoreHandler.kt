package com.rexijie.highschoolportal.web.api.v1.handlers

import com.rexijie.highschoolportal.model.Score
import com.rexijie.highschoolportal.service.ScoreService
import org.springframework.http.CacheControl
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class ScoreHandler(private val scoreService: ScoreService) {

    fun getScoreById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("scoreId")
        return ServerResponse
                .ok()
                .cacheControl(CacheControl.noCache())
                .body(scoreService.getScoreById(id))
    }

    fun updateStudentScore(request: ServerRequest): Mono<ServerResponse> {
        val scoreId = request.pathVariable("scoreId")
        val updatedScore = request.bodyToMono<Score>()
        return updatedScore.flatMap {
            ServerResponse
                    .ok()
                    .body(scoreService.updateScore(scoreId, it))
        }
    }
}