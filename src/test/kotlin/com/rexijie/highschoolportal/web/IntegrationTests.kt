package com.rexijie.highschoolportal.web

import com.rexijie.highschoolportal.model.Student
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList

class IntegrationTests {

    val testClient =  WebTestClient
        .bindToServer()
            .baseUrl("http://localhost:8080/api/v1")
            .build()

    @Test
    fun `Find All Clients`() {
        testClient.get().uri("/student")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBodyList<Student>()
                .hasSize(1)
    }

    @Test
    fun `Should use ErrorHandler Class`() {
       testClient.get().uri("/student/id")
               .accept(MediaType.APPLICATION_JSON)
               .exchange()
               .expectStatus().isNoContent
               .expectBody().isEmpty
    }
}