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
        var firstTest: Int = 0,
        var secondTest: Int = 0,
        var exam: Int = 0,
        var assignment: Int = 0,
        var total: Int = firstTest + secondTest + exam + assignment
) {
    fun calculateTotal() {
        total = firstTest + secondTest + exam + assignment
        if (total > 100) total = 100
    }
}