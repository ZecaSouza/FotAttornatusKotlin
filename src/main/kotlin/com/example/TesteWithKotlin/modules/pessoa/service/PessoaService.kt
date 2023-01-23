package com.example.TesteWithKotlin.modules.pessoa.service

import com.example.TesteWithKotlin.models.dtos.PessoaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PessoaService {

    fun getAllPessoa(): Flux<PessoaDTO>
    fun getPessoaById(pessoaId: Long): Mono<PessoaDTO>
    fun createPessoa(pessoaDTO: PessoaDTO): Mono<PessoaDTO>
    fun putPessoa(pessoaId: Long,pessoaDTO: PessoaDTO): Mono<PessoaDTO>
    fun deletePessoa(pessoaId: Long): Mono<Void>

}