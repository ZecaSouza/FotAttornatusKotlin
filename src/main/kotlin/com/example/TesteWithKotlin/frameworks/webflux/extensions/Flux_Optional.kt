package io.example.TesteWithKotlin.frameworks.webflux.extensions

import reactor.core.publisher.Flux

inline fun <reified T: Any> Flux<T?>.removelNulls(): Flux<T> = collectList()
    .map { it.filterNotNull() }
    .flatMapMany { Flux.fromIterable(it as List<T>) }