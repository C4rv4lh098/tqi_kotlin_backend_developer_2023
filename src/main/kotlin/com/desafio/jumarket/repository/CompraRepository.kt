package com.desafio.jumarket.repository

import com.desafio.jumarket.entity.Compra
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompraRepository: JpaRepository<Compra, Long> {
}