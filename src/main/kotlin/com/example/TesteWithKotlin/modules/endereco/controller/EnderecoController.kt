package com.example.TesteWithKotlin.modules.endereco.controller

import com.example.TesteWithKotlin.models.dtos.EnderecoDTO
import com.example.TesteWithKotlin.modules.endereco.service.EnderecoService
import org.hibernate.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("endereco")
@Validated
class EnderecoController(
    private val service: EnderecoService
) {

    @GetMapping("/{pessoaId}", produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun getAllEnderecoByPessoa(@PathVariable pessoaId: Long): Flux<EnderecoDTO> = service.getAllEnderecoByPessoa(pessoaId)

    @PostMapping(produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun createEnderecoForPessoa(@RequestBody enderecoDTO: EnderecoDTO): Mono<EnderecoDTO> = service.createEnderecoForPessoa(enderecoDTO)

    @PutMapping("/{enderecoId}", produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun putEndereco(@PathVariable enderecoId: Long, @RequestBody enderecoDTO: EnderecoDTO): Mono<EnderecoDTO> = service.putEndereco(enderecoId, enderecoDTO)

    @DeleteMapping("/{enderecoId}", produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun deleteEndereco(@PathVariable enderecoId: Long) = service.deleteEndereco(enderecoId)

}