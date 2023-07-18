package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Carrinho
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.enummeration.Pagamento
import jakarta.validation.constraints.NotNull

data class CarrinhoViewList(
        val produto: List<Produto>,

        val valorTotal: Double,

        val pagamento: Pagamento
){
    constructor(carrinho: Carrinho): this(
            produto = carrinho.produto,
            valorTotal = carrinho.valorTotal,
            pagamento = carrinho.pagamento

    )
}
