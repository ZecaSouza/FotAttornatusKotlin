package com.example.TesteWithKotlin.models.dtos

import com.example.TesteWithKotlin.datbase.entities.Endereco
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class EnderecoDTO(
    @JsonProperty("id")
    var id: Long = 0,

    @JsonProperty("rua")
    var rua: String = String(),

    @JsonProperty("cidade")
    var cidade: String = String(),

    @JsonProperty("estado")
    var estado: String = String(),

    @JsonProperty("cep")
    var cep: Long = 0,

    @JsonProperty("pessoa")
    val pessoa: Long
) : Serializable {

    constructor(endereco: Endereco): this(
        id = endereco.id,
        rua = endereco.rua,
        cidade = endereco.cidade,
        estado = endereco.estado,
        cep = endereco.cep,
        pessoa = endereco.pessoa.id
    )

}
