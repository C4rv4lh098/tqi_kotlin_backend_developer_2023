package com.desafio.jumarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.Random

@SpringBootApplication
class JumarketApplication

fun main(args: Array<String>) {
	runApplication<JumarketApplication>(*args)
}