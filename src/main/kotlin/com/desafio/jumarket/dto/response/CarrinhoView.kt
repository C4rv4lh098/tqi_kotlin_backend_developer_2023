package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.enummeration.Pagamento
import jakarta.validation.constraints.NotNull

class CarrinhoView(
        val clienteId: Long,
        val produtoId: List<Long>,
        val pagamento: Pagamento
) {
    constructor(carrinho: Carrinho): this(
            clienteId = carrinho.clienteId,
            produtoId = carrinho.produtoId,
            pagamento = carrinho.pagamento
    )
}