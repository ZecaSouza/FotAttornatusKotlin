package com.example.TesteWithKotlin.modules.pessoa.controller

import com.example.TesteWithKotlin.models.dtos.PessoaDTO
import com.example.TesteWithKotlin.modules.pessoa.service.PessoaService
import org.hibernate.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("pessoa")
@Validated
class PessoaController (
    private val service: PessoaService
){

    @GetMapping("/", produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun getAllPessoa(): Flux<PessoaDTO> = service.getAllPessoa()

    @GetMapping("/{pessoaId}", produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun getPessoaById(@PathVariable pessoaId: Long): Mono<PessoaDTO> = service.getPessoaById(pessoaId)

    @PostMapping(produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun createPessoa( @RequestBody pessoaDTO: PessoaDTO): Mono<PessoaDTO> = service.createPessoa(pessoaDTO)

    @PutMapping("/{pessoaId}", produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun putPessoa(@PathVariable pessoaId: Long, @RequestBody pessoaDTO: PessoaDTO): Mono<PessoaDTO> = service.putPessoa(pessoaId, pessoaDTO)

    @DeleteMapping("/{pessoaId}", produces = ["application/json"])
    @ResponseStatus(HttpStatus.OK)
    fun deletePessoa(@PathVariable pessoaId: Long) = service.deletePessoa(pessoaId)
}