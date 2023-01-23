package com.example.TesteWithKotlin.datbase.repositories

import com.example.TesteWithKotlin.datbase.entities.Endereco
import com.example.TesteWithKotlin.datbase.entities.Pessoa
import org.springframework.data.jpa.repository.JpaRepository

interface EnderecoRepositry: JpaRepository<Endereco, Long>