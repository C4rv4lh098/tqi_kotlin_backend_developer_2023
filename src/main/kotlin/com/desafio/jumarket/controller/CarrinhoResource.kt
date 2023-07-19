package com.desafio.jumarket.controller

import com.desafio.jumarket.dto.request.CarrinhoDto
import com.desafio.jumarket.dto.response.CarrinhoViewList
import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.service.impl.CarrinhoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CarrinhoViewList>{
        val carrinho: Carrinho = this.carrinhoService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CarrinhoViewList(carrinho))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCarrinho(@PathVariable id: Long) = this.carrinhoService.delete(id)
}