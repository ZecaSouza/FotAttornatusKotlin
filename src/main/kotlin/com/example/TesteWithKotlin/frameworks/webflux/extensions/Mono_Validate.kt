package io.example.TesteWithKotlin.frameworks.webflux.extensions


import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceError
import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceException
import reactor.core.publisher.Mono

inline fun <reified T : Any> Mono<T>.validateOrThrow(
    error: ServiceError,
    crossinline expression: (T) -> Boolean
): Mono<T> = doOnNext { if (expression(it).not()) throw ServiceException(error) }
