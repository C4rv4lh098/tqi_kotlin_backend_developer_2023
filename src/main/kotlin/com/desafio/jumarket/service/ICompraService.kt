package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Compra

interface ICompraService {
    fun save(compra: Compra): Compra

    fun findById(id: Long): Compra

    fun delete(id: Long)
}