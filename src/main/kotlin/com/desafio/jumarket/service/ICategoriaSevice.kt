package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Categoria


interface ICategoriaSevice {
    fun save(categoria: Categoria): Categoria

    fun findById(id: Long): Categoria

    fun findAll(): List<Categoria>

    fun delete(id: Long)
}