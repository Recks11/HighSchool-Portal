package com.rexijie.highschoolportal.model

import org.springframework.data.annotation.Id
import java.util.UUID

data class Subject(
        @Id val id: String = UUID.randomUUID().toString(),
        val name: String
)