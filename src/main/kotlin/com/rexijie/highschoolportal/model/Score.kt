package com.rexijie.highschoolportal.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document
data class Score(
        @Id val id: String = UUID.randomUUID().toString(),
        val subject: Subject?,
        val term: Int = 1,
        val firstTest: Int = 0,
        val secondTest: Int = 0,
        val exam: Int = 0,
        val assignment: Int = 0,
        val total: Int = firstTest + secondTest + exam + assignment
)