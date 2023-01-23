package com.example.TesteWithKotlin.models.dtos

import com.example.TesteWithKotlin.datbase.entities.Pessoa
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.time.LocalDate

data class PessoaDTO(
    @JsonProperty("id")
    val id: Long = 0,

    @JsonProperty("nome")
    val nome: String = String(),

    @JsonProperty("data_nascimento")
    val dataNascimento: LocalDate? = null
)  : Serializable {

    constructor(pessoa: Pessoa): this(
        id = pessoa.id,
        nome = pessoa.name,
        dataNascimento = pessoa.dataNascimento
    )

}