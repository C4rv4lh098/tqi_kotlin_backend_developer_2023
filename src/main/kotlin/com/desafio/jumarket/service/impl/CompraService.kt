package com.desafio.jumarket.service.impl

import com.desafio.jumarket.entity.Compra
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.CompraRepository
import com.desafio.jumarket.service.ICompraService
import org.springframework.stereotype.Service

@Service
data class CompraService(
        private val compraRepository: CompraRepository
): ICompraService {
    override fun save(compra: Compra): Compra =
            this.compraRepository.save(compra)

    override fun findById(id: Long): Compra =
            this.compraRepository.findById(id).orElseThrow {
                throw BusinessException("Compra $id not found")
            }

    override fun delete(id: Long) {
        val compra: Compra = this.findById(id)
        this.compraRepository.delete(compra)
    }
}
