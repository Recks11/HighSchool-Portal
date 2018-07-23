package com.rexijie.highschoolportal.model

import com.rexijie.highschoolportal.model.enums.Branch
import com.rexijie.highschoolportal.model.enums.Level
import org.springframework.data.annotation.Id
import java.util.UUID

data class Subject(
        @Id val id: String = UUID.randomUUID().toString(),
        val name: String,
        val level: Level,
        val branch: Branch?
)