package com.example.TesteWithKotlin.models.errors

import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceError
import org.springframework.http.HttpStatus

enum class TesteErro(
    override val status: HttpStatus,
    override val message: String
):ServiceError {

    PESSOA_NOT_FOUND(HttpStatus.NOT_FOUND, "pessoa.not.found"),
    RESOURCE_NOT_FOUND(HttpStatus.BAD_REQUEST, "resource.not.found"),
    ENDERECO_NOT_FOUND(HttpStatus.NOT_FOUND, "endereco.not.found")

}