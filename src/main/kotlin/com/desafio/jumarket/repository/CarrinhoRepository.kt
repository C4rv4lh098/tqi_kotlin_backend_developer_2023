package com.desafio.jumarket.repository

import com.desafio.jumarket.entity.Carrinho
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CarrinhoRepository: JpaRepository<Carrinho, Long> {
    @Query(value = "SELECT * FROM CARRINHO WHERE CLIENTE_ID = ?1", nativeQuery = true)
    fun findAllByClientId(ClienteId: Long): List<Carrinho>
}