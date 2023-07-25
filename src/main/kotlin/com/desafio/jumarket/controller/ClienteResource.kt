package com.desafio.jumarket.controller

import com.desafio.jumarket.dto.request.ClienteDto
import com.desafio.jumarket.dto.response.ClienteView
import com.desafio.jumarket.entity.Cliente
import com.desafio.jumarket.service.impl.ClienteService
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
@RequestMapping("/api/cliente")
class ClienteResource(
        private val clienteService: ClienteService
) {
    @PostMapping
    fun saveCliente(@RequestBody @Valid carrinhoDto: ClienteDto): ResponseEntity<String>{
        val savedCliente = this.clienteService.save(carrinhoDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente ${savedCliente.nome} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ClienteView>{
        val cliente: Cliente = this.clienteService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(ClienteView(cliente))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCliente(@PathVariable id: Long) = this.clienteService.delete(id)
}