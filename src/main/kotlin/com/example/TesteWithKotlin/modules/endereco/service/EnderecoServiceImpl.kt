package com.example.TesteWithKotlin.modules.endereco.service

import com.example.TesteWithKotlin.datbase.entities.Endereco
import com.example.TesteWithKotlin.datbase.repositories.EnderecoRepositry
import com.example.TesteWithKotlin.datbase.repositories.PessoaRepositry
import com.example.TesteWithKotlin.models.dtos.EnderecoDTO
import com.example.TesteWithKotlin.models.errors.TesteErro
import io.example.TesteWithKotlin.frameworks.webflux.extensions.AsyncMonoThrowIfEmpty
import io.example.TesteWithKotlin.frameworks.webflux.extensions.validateOrThrow
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class EnderecoServiceImpl(
    private val pessoaRepositry: PessoaRepositry,
    private val enderecoRepositry: EnderecoRepositry
): EnderecoService {

    override fun getAllEnderecoByPessoa(pessoaId: Long): Flux<EnderecoDTO> =
        AsyncMonoThrowIfEmpty(TesteErro.PESSOA_NOT_FOUND) { pessoaRepositry.findByIdOrNull(pessoaId) }
            .flatMapIterable { pessoa -> pessoa.enderecoList }
            .map { EnderecoDTO(it) }

    override fun createEnderecoForPessoa(enderecoDTO: EnderecoDTO): Mono<EnderecoDTO> =
        AsyncMonoThrowIfEmpty(TesteErro.PESSOA_NOT_FOUND) { pessoaRepositry.findByIdOrNull(enderecoDTO.pessoa) }
            .map { Endereco(enderecoDTO, it) }
            .map { enderecoRepositry.save(it) }
            .map { EnderecoDTO(it) }

    override fun putEndereco(enderecoId: Long, enderecoDTO: EnderecoDTO): Mono<EnderecoDTO> =
        AsyncMonoThrowIfEmpty(TesteErro.ENDERECO_NOT_FOUND) { enderecoRepositry.findByIdOrNull(enderecoId) }
            .validateOrThrow(TesteErro.RESOURCE_NOT_FOUND) { pessoaRepositry.findByIdOrNull(it.pessoa.id) == it.pessoa }
            .map { Endereco(enderecoDTO, it.pessoa) }
            .map { enderecoRepositry.save(it) }
            .map { EnderecoDTO(it) }

    override fun deleteEndereco(enderecoId: Long): Mono<Void> =
        AsyncMonoThrowIfEmpty(TesteErro.ENDERECO_NOT_FOUND) { enderecoRepositry.findByIdOrNull(enderecoId) }
            .map { enderecoRepositry.deleteById(enderecoId) }
            .then()

}