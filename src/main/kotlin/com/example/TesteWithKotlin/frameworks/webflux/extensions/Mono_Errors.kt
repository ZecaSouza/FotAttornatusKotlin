package io.example.TesteWithKotlin.frameworks.webflux.extensions

import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceError
import reactor.core.publisher.Mono

inline fun <reified T: Any> Mono<T>.onErrorMap2ServiceError(crossinline callback: (Throwable) -> ServiceError): Mono<T> = onErrorMap {
    val serviceError = callback(it)
    io.example.TesteWithKotlin.frameworks.spring.errors.ServiceException(serviceError)
}