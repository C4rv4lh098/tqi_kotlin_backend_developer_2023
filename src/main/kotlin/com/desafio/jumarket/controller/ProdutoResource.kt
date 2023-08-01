package com.desafio.jumarket.controller

import com.desafio.jumarket.dto.request.ProdutoDto
import com.desafio.jumarket.dto.request.ProdutoUpdateDto
import com.desafio.jumarket.dto.response.ProdutoView
import com.desafio.jumarket.dto.response.ProdutoViewList
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.service.impl.ProdutoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/produto")
class ProdutoResource(
        private val produtoService: ProdutoService
) {
    @PostMapping
    fun saveProduto(@RequestBody @Valid produtoDto: ProdutoDto): ResponseEntity<String>{
        val savedProduto = this.produtoService.save(produtoDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto ${savedProduto.nome} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ProdutoView>{
        val produto: Produto = this.produtoService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(ProdutoView(produto))
    }

    @GetMapping
    fun findAllByCategoriaId(@RequestParam(value = "categoriaId") categoriaId: Long): ResponseEntity<List<ProdutoViewList>>{
        val produtoViewList: List<ProdutoViewList> = this.produtoService.findAllByCategoria(categoriaId).stream()
                .map{produto: Produto -> ProdutoViewList(produto)}
                .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(produtoViewList)
    }

    @GetMapping("/produtos")
    fun findAllProdutos(): ResponseEntity<List<ProdutoView>>{
        val produtoList: List<ProdutoView> = this.produtoService.findAll().stream()
                .map {produto: Produto -> ProdutoView(produto)}
                .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(produtoList)
    }

    @PatchMapping
    fun updateProduto(@RequestParam(value = "produtoId") id: Long,
                      @RequestBody @Valid produtoUpdateDto: ProdutoUpdateDto): ResponseEntity<ProdutoView>{
        val produto: Produto = this.produtoService.findById(id)
        val produtoToUpdate: Produto = produtoUpdateDto.toEntity(produto)
        val produtoUpdated: Produto = this.produtoService.save(produtoToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(ProdutoView(produtoUpdated))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduto(@PathVariable id: Long) = this.produtoService.delete(id)
}