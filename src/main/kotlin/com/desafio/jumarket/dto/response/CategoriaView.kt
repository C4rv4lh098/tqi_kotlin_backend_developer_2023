package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Categoria

data class CategoriaView(
        val categoriaId: Long?,
        val nome: String
){
    constructor(categoria: Categoria): this(
            categoriaId = categoria.id,
            nome = categoria.nome
    )
}
