package io.example.TesteWithKotlin.frameworks.webflux.extensions


import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceError
import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceException
import reactor.core.publisher.Flux

inline fun <reified T : Any> Flux<T>.validateOrThrow(
    error: ServiceError,
    crossinline expression: (T) -> Boolean
): Flux<T> = doOnNext { if (expression(it).not()) throw ServiceException(error) }
