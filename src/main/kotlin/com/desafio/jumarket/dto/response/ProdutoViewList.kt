package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Produto

data class ProdutoViewList(
        val nome: String,
        val unidadeMedida: String,
        val preco: Double
) {
    constructor(produto: Produto): this(
            nome = produto.nome,
            unidadeMedida = produto.unidadeMedida,
            preco = produto.preco
    )
}
