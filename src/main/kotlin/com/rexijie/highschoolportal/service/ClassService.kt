package com.rexijie.highschoolportal.service

import com.rexijie.highschoolportal.model.HighSchoolClass
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ClassService {
    fun findAllClasses(): Flux<HighSchoolClass>
    fun findClassById(id: String): Mono<HighSchoolClass>
}