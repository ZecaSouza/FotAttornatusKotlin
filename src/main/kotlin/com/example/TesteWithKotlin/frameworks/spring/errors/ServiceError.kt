package io.example.TesteWithKotlin.frameworks.spring.errors

import org.springframework.http.HttpStatus

interface ServiceError {

    val status: HttpStatus
    val message: String

}