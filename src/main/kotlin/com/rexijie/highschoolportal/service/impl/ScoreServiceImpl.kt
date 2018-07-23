package com.rexijie.highschoolportal.service.impl

import com.rexijie.highschoolportal.exception.NotFoundException
import com.rexijie.highschoolportal.model.Score
import com.rexijie.highschoolportal.repository.ScoreRepository
import com.rexijie.highschoolportal.service.ScoreService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ScoreServiceImpl(private val scoreRepository: ScoreRepository) : ScoreService {
    override fun getScoreById(id: String): Mono<Score> {
        return scoreRepository.findById(id)
                .switchIfEmpty(Mono.error(NotFoundException("Record does not Exist")))
    }

    override fun updateScore(id: String, score: Score): Mono<Score> {
        return getScoreById(id)
                .flatMap {
                    it.firstTest = score.firstTest
                    it.secondTest = score.secondTest
                    it.assignment = score.assignment
                    it.exam = score.exam
                    it.calculateTotal()
                    scoreRepository.save(it)
                }
    }


}