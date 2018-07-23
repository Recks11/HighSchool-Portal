package com.rexijie.highschoolportal.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Student(@Id var id: String = UUID.randomUUID().toString(),
                   @JsonProperty("firstname") var firstName: String,
                   @JsonProperty("lastname") var lastName: String,
                   @JsonProperty("class") var currentClass: String,
                   @JsonProperty("arm") var classArm: String,
                   @JsonProperty("registrationnumber")var registrationNumber: String,
                   var sex: String,
                   var admissionDate: String,
                   @JsonIgnore @DBRef(lazy = true) var scores: MutableList<Score>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (currentClass != other.currentClass) return false
        if (classArm != other.classArm) return false
        if (registrationNumber != other.registrationNumber) return false
        if (sex != other.sex) return false
        if (admissionDate != other.admissionDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + currentClass.hashCode()
        result = 31 * result + classArm.hashCode()
        result = 31 * result + registrationNumber.hashCode()
        result = 31 * result + sex.hashCode()
        result = 31 * result + admissionDate.hashCode()
        return result
    }
}