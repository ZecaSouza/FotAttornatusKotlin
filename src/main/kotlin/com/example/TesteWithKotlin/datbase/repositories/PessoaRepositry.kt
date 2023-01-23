package com.example.TesteWithKotlin.datbase.repositories

import com.example.TesteWithKotlin.datbase.entities.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface PessoaRepositry: JpaRepository<Pessoa, Long>