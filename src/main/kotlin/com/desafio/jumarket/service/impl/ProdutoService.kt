package com.desafio.jumarket.service.impl

import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.ProdutoRepository
import com.desafio.jumarket.service.IProdutoService
import org.springframework.stereotype.Service

@Service
class ProdutoService(
        private val produtoRepository: ProdutoRepository,
        private val categoriaService: CategoriaService
): IProdutoService {
    override fun save(produto: Produto): Produto {
        produto.apply {
            categoria = categoriaService.findById(produto.categoria?.id!!)
        }
        return this.produtoRepository.save(produto)
    }

    override fun findById(id: Long): Produto =
            this.produtoRepository.findById(id).orElseThrow {
                throw BusinessException("Id %id not found")
            }

    override fun findAllByCategoria(categoriaId: Long): List<Produto> =
            this.produtoRepository.findAllByCategoriaId(categoriaId)

    override fun delete(id: Long) {
        val produto: Produto = this.findById(id)
        this.produtoRepository.delete(produto)
    }
}