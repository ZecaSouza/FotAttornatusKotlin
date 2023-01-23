package com.example.TesteWithKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TesteWithKotlinApplication

fun main(args: Array<String>) {
	runApplication<TesteWithKotlinApplication>(*args)
}