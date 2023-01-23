package com.example.TesteWithKotlin.frameworks.webflux.extensions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux

fun <T> AsyncFlux(dataSource: () -> Iterable<T>): Flux<T> = Flux.defer { Flux.fromIterable(dataSource()) }
    .onErrorMap {
        when (it) {
            is ResponseStatusException -> it
            else -> ResponseStatusException(HttpStatus.BAD_REQUEST, it.message)
        }
    }