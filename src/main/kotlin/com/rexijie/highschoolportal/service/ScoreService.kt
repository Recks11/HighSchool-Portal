package com.rexijie.highschoolportal.service

import com.rexijie.highschoolportal.model.Score
import reactor.core.publisher.Mono

interface ScoreService {
    fun getScoreById(id: String): Mono<Score>
    fun updateScore(id: String, score: Score): Mono<Score>
}