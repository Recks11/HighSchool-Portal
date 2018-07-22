package com.rexijie.highschoolportal.model

import java.time.LocalDateTime

data class ErrorResponse (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val error: String = "",
    val message: String = ""
)