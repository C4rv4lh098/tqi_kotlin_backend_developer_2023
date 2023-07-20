package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.entity.Produto

data class ProdutoView(
        val nome: String,
        val unidadeMedida: String,
        val preco: Double,
        val categoria: Categoria
) {
    constructor(produto: Produto): this(
            nome = produto.nome,
            unidadeMedida = produto.unidadeMedida,
            preco = produto.preco,
            categoria = produto.categoria
    )
}
