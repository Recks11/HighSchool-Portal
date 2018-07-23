package com.rexijie.highschoolportal.model

import java.time.LocalDateTime

data class ErrorResponse (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val path: String,
    val error: String,
    val reason: String,
    val message: String
)