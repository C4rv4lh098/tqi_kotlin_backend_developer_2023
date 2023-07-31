package com.desafio.jumarket.repository

import com.desafio.jumarket.entity.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: JpaRepository<Categoria, Long> {
    @Query(value = "SELECT * FROM CATEGORIA", nativeQuery = true)
    fun findAllCategorias(): List<Categoria>
}
