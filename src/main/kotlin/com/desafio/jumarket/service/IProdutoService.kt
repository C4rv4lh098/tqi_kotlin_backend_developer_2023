package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Produto

interface IProdutoService {
    fun save(produto: Produto): Produto

    fun findById(id: Long): Produto

    fun findAllByCategoria(categoriaId: Long): List<Produto>

    fun findAll(): List<Produto>

    fun delete(id: Long)
}