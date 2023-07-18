package com.desafio.jumarket.repository

import com.desafio.jumarket.entity.Carrinho
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarrinhoRepository: JpaRepository<Carrinho, Long>{
}