package com.rexijie.highschoolportal.repository

import com.rexijie.highschoolportal.model.Score
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ScoreRepository: ReactiveMongoRepository<Score, String> {
}