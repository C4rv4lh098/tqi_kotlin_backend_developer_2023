package com.desafio.jumarket.service.impl

import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.CategoriaRepository
import com.desafio.jumarket.service.ICategoriaSevice

class CategoriaService(
        private val categoriaRepository: CategoriaRepository
): ICategoriaSevice {
    override fun save(categoria: Categoria): Categoria =
            this.categoriaRepository.save(categoria)

    override fun findById(id: Long): Categoria =
            this.categoriaRepository.findById(id).orElseThrow{
                throw BusinessException("Id %id not found")
            }

    override fun delete(id: Long) {
        val categoria: Categoria = this.findById(id)
        this.categoriaRepository.delete(categoria)
    }
}