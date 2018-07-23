package com.rexijie.highschoolportal.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document data class Teacher(
        @Id val id: String = UUID.randomUUID().toString(),
        @JsonProperty("firstname") val firstName: String,
        @JsonProperty("lastname") val lastName: String,
        @JsonProperty("teachernumber") val teacherNumber: String,
        @JsonIgnore val subjects: MutableList<Subject>?
)