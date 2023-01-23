package com.example.TesteWithKotlin.modules.endereco.service

import com.example.TesteWithKotlin.models.dtos.EnderecoDTO
import com.example.TesteWithKotlin.models.dtos.PessoaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface EnderecoService {

    fun getAllEnderecoByPessoa(pessoaId: Long): Flux<EnderecoDTO>
    fun createEnderecoForPessoa(enderecoDTO: EnderecoDTO): Mono<EnderecoDTO>
    fun putEndereco(enderecoId: Long,enderecoDTO: EnderecoDTO): Mono<EnderecoDTO>
    fun deleteEndereco(enderecoId: Long): Mono<Void>

}