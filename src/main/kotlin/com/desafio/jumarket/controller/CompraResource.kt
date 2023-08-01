package com.desafio.jumarket.controller

import com.desafio.jumarket.dto.request.CompraDto
import com.desafio.jumarket.dto.response.CompraView
import com.desafio.jumarket.entity.Compra
import com.desafio.jumarket.service.impl.CompraService
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
@RequestMapping("/api/compra")
class CompraResource(
        private val compraService: CompraService
) {
    @PostMapping
    fun saveCompra(@RequestBody @Valid compraDto: CompraDto): ResponseEntity<String>{
        val savedCompra = this.compraService.save(compraDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Compra ${savedCompra.id} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CompraView>{
        val compra: Compra = this.compraService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CompraView(compra))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCompra(@PathVariable id: Long) = this.compraService.delete(id)
}