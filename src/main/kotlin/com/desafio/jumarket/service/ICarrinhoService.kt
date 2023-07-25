package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Carrinho

interface ICarrinhoService {
    fun save(carrinho: Carrinho): Carrinho

    fun finById(id: Long): Carrinho

    fun delete(id: Long)
}