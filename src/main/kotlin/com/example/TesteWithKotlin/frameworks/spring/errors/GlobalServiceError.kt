package io.example.TesteWithKotlin.frameworks.spring.errors

import org.springframework.http.HttpStatus

enum class GlobalServiceError(
    override val status: HttpStatus,
    override val message: String
) : ServiceError {

    INVALID_FIELD_DATA(HttpStatus.BAD_REQUEST, "invalid.field.data"),
    INVALID_ACCESS(HttpStatus.FORBIDDEN, "invalid.access"),
    RESOURCE_NOT_FOUND(HttpStatus.BAD_REQUEST, "resource.not.found");

}