package com.example.TesteWithKotlin.datbase.entities

import com.example.TesteWithKotlin.models.dtos.PessoaDTO
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "pessoa")
@EntityListeners(AuditingEntityListener::class)
open class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id", nullable = false)
    open var id: Long = 0,

    @Column(name = "name", nullable = false)
    open var name: String = String(),

    @Column(name = "data_nascimento", nullable = false)
    open var dataNascimento: LocalDate? = null,

    @OneToMany(mappedBy = "pessoa")
    open var enderecoList: MutableSet<Endereco> = mutableSetOf(),
) {

    constructor(pessoaDTO: PessoaDTO): this (
        id = pessoaDTO.id,
        name = pessoaDTO.nome,
        dataNascimento = pessoaDTO.dataNascimento
    )
}
