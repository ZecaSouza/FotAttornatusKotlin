package com.example.TesteWithKotlin.datbase.entities

import com.example.TesteWithKotlin.models.dtos.EnderecoDTO
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@Entity
@Table(name = "endereco")
@EntityListeners(AuditingEntityListener::class)
open class Endereco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
     open var id: Long = 0,

    @Column(name = "rua")
    open var rua: String = String(),

    @Column(name = "cidade")
    open var cidade: String = String(),

    @Column(name = "estado")
    open var estado: String = String(),

    @Column(name = "cep")
    open var cep: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    open var pessoa: Pessoa
) {

    constructor(enderecoDTO: EnderecoDTO, pessoa: Pessoa): this(
        id = enderecoDTO.id,
        rua = enderecoDTO.rua,
        cidade = enderecoDTO.cidade,
        estado = enderecoDTO.estado,
        cep = enderecoDTO.cep,
        pessoa = pessoa
    )

}
