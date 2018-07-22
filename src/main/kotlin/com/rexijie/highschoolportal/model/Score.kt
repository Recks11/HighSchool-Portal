package com.rexijie.highschoolportal.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document
data class Score(
        @Id val id: String = UUID.randomUUID().toString(),
        @DBRef(lazy = true) val subject: Subject?,
        val term: Int,
        val session: String,
        val firstTest: Int = 0,
        val secondTest: Int = 0,
        val exam: Int = 0,
        val assignment: Int = 0,
        val total: Int = firstTest + secondTest + exam + assignment
)