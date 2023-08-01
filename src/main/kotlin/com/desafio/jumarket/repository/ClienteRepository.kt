package com.desafio.jumarket.repository

import com.desafio.jumarket.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> {
    @Query(value = "SELECT * FROM CLIENTE WHERE NOME = ?1", nativeQuery = true)
    fun findClienteByNome(nome: String): Cliente
}