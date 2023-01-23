package com.example.TesteWithKotlin.modules.pessoa.service

import com.example.TesteWithKotlin.datbase.entities.Pessoa
import com.example.TesteWithKotlin.datbase.repositories.PessoaRepositry
import com.example.TesteWithKotlin.frameworks.webflux.extensions.AsyncFlux
import com.example.TesteWithKotlin.models.dtos.PessoaDTO
import com.example.TesteWithKotlin.models.errors.TesteErro
import io.example.TesteWithKotlin.frameworks.webflux.extensions.AsyncMono
import io.example.TesteWithKotlin.frameworks.webflux.extensions.AsyncMonoThrowIfEmpty
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PessoaServiceImpl(
    private val pessoaRepositry: PessoaRepositry
):PessoaService {

    override fun getAllPessoa(): Flux<PessoaDTO> =
        AsyncFlux { pessoaRepositry.findAll() }
            .map { PessoaDTO(it) }

    override fun getPessoaById(pessoaId: Long): Mono<PessoaDTO> =
        AsyncMonoThrowIfEmpty(TesteErro.PESSOA_NOT_FOUND) { pessoaRepositry.findByIdOrNull(pessoaId) }
            .map { PessoaDTO(it) }

    override fun createPessoa(pessoaDTO: PessoaDTO): Mono<PessoaDTO> =
        AsyncMono { Pessoa(pessoaDTO) }
            .map { pessoaRepositry.save(it) }
            .map { PessoaDTO(it) }

    override fun putPessoa(pessoaId: Long, pessoaDTO: PessoaDTO): Mono<PessoaDTO> =
        AsyncMonoThrowIfEmpty(TesteErro.PESSOA_NOT_FOUND) { pessoaRepositry.findByIdOrNull(pessoaId) }
            .map { Pessoa(pessoaDTO) }
            .map { pessoaRepositry.save(it) }
            .map { PessoaDTO(it) }

    override fun deletePessoa(pessoaId: Long): Mono<Void> =
        AsyncMonoThrowIfEmpty(TesteErro.PESSOA_NOT_FOUND) { pessoaRepositry.findByIdOrNull(pessoaId) }
            .map { pessoaRepositry.deleteById(pessoaId) }
            .then()


}