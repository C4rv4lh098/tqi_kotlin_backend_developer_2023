package com.desafio.jumarket.controller

import com.desafio.jumarket.dto.request.CarrinhoDto
import com.desafio.jumarket.service.impl.CarrinhoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/carrinho")
class CarrinhoResource(
        private val carrinhoService: CarrinhoService
) {
    @PostMapping
    fun saveCarrinho(@RequestBody @Valid carrinhoDto: CarrinhoDto): ResponseEntity<String>{
        val savedCarrinho = this.carrinhoService.save(carrinhoDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Compra ${savedCarrinho.id} saved")
    }
}