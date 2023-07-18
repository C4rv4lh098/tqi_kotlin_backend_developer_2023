package com.desafio.jumarket.service.impl

import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.CarrinhoRepository
import com.desafio.jumarket.service.ICarrinhoService

class CarrinhoService(
        private val carrinhoRepository: CarrinhoRepository
): ICarrinhoService {
    override fun save(carrinho: Carrinho): Carrinho =
            this.carrinhoRepository.save(carrinho)

    override fun findById(id: Long): Carrinho =
            this.carrinhoRepository.findById(id).orElseThrow {
                throw BusinessException("Id %id not found")
            }

    override fun delete(id: Long) {
        val carrinho: Carrinho = this.findById(id)
        this.carrinhoRepository.delete(carrinho)
    }
}