package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Carrinho

class CarrinhoViewList (
        val produtoId: Long
) {
    constructor(carrinho: Carrinho): this(
            produtoId = carrinho.produtoId
    )
}