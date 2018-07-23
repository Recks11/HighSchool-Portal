package com.rexijie.highschoolportal.model

import com.fasterxml.jackson.annotation.JsonRootName
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document
@JsonRootName("class")
data class HighSchoolClass(
        @Id val id: String = UUID.randomUUID().toString(),
        val name: String,
        @DBRef(lazy = true) val subjects: MutableList<Subject>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HighSchoolClass

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}