package com.desafio.jumarket.repository

import com.desafio.jumarket.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository: JpaRepository<Produto ,Long> {
    @Query(value = "SELECT * FROM PRODUTO WHERE CATEGORIA_ID = ?1", nativeQuery = true)
    fun findAllByCategoriaId(categoriaId: Long): List<Produto>
}