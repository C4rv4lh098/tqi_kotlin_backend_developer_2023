package com.desafio.jumarket.controller

import com.desafio.jumarket.dto.request.CategoriaDTO
import com.desafio.jumarket.service.impl.CategoriaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/categoria")
class CategoriaResource(
        private val categoriaService: CategoriaService
) {
    @PostMapping
    fun saveCategoria(@RequestBody @Valid categoriaDTO: CategoriaDTO): ResponseEntity<String>{
        val savedCategoria = this.categoriaService.save(categoriaDTO.toEntity())
        return ResponseEntity.status(HttpStatus.OK).body("Categoria ${savedCategoria.nome} saved!")
    }
}