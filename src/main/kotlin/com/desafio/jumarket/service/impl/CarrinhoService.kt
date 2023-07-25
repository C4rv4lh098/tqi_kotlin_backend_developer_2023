package com.desafio.jumarket.service.impl

import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.CarrinhoRepository
import com.desafio.jumarket.service.ICarrinhoService
import org.springframework.stereotype.Service

@Service
data class CarrinhoService(
        private val carrinhoRepository: CarrinhoRepository
): ICarrinhoService {
    override fun save(carrinho: Carrinho): Carrinho =
            this.carrinhoRepository.save(carrinho)

    override fun finById(id: Long): Carrinho =
            this.carrinhoRepository.findById(id).orElseThrow {
                throw BusinessException("carrinhoId %id not found")
            }

    override fun findAllByCliente(clienteId: Long): List<Carrinho> =
            this.carrinhoRepository.findAllByClientId(clienteId)

    override fun delete(id: Long) {
        val carrinho: Carrinho = this.finById(id)
        this.carrinhoRepository.delete(carrinho)
    }
}
