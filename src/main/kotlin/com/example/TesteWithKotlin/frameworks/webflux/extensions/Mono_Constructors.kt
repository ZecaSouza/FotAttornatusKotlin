package io.example.TesteWithKotlin.frameworks.webflux.extensions


import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceError
import io.example.TesteWithKotlin.frameworks.spring.errors.ServiceException
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

fun <T : Any> AsyncMono(dataSource: () -> T): Mono<T> = Mono.fromCallable { dataSource() }
    .onErrorMap {
        when (it) {
            is ResponseStatusException -> it
            is ServiceException -> it
            else -> ResponseStatusException(HttpStatus.BAD_REQUEST, it.message)
        }
    }

fun <T : Any> AsyncMonoThrowIfEmpty(serviceError: ServiceError, dataSource: () -> T?): Mono<T> = Mono.fromCallable { dataSource() ?: throw ServiceException(serviceError) }
    .onErrorMap {
        when (it) {
            is ResponseStatusException -> it
            is ServiceException -> it
            else -> ResponseStatusException(HttpStatus.BAD_REQUEST, it.message)
        }
    }