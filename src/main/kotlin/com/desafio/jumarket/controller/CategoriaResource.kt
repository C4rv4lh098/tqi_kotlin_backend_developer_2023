package com.desafio.jumarket.controller

import com.desafio.jumarket.dto.request.CategoriaDto
import com.desafio.jumarket.dto.response.CategoriaView
import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.service.impl.CategoriaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/categoria")
class CategoriaResource(
        private val categoriaService: CategoriaService
) {
    @PostMapping
    fun saveCategoria(@RequestBody @Valid categoriaDTO: CategoriaDto): ResponseEntity<String>{
        val savedCategoria = this.categoriaService.save(categoriaDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria ${savedCategoria.nome} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CategoriaView>{
        val categoria: Categoria = this.categoriaService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CategoriaView(categoria))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategoria(@PathVariable id: Long) = this.categoriaService.delete(id)
}