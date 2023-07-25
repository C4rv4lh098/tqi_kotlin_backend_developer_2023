package com.desafio.jumarket.service.impl

import com.desafio.jumarket.entity.Cliente
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.ClienteRepository
import com.desafio.jumarket.service.IClienteService
import org.springframework.stereotype.Service

@Service
data class ClienteService(
        private val clienteRepository: ClienteRepository
): IClienteService {
    override fun save(cliente: Cliente): Cliente =
            this.clienteRepository.save(cliente)

    override fun findById(id: Long): Cliente =
            this.clienteRepository.findById(id).orElseThrow {
                throw BusinessException("Id %id not found")
            }

    override fun delete(id: Long) {
        val cliente: Cliente = this.findById(id)
        this.clienteRepository.delete(cliente)
    }
}
