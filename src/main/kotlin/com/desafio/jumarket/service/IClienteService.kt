package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Cliente

interface IClienteService {
    fun save (cliente: Cliente): Cliente

    fun findById(id: Long): Cliente

    fun delete(id:Long)
}