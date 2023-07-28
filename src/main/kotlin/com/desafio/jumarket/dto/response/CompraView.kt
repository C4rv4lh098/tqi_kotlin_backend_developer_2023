package com.desafio.jumarket.dto.response

import com.desafio.jumarket.entity.Cliente
import com.desafio.jumarket.entity.Compra
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.enummeration.Pagamento

data class CompraView(
        val cliente: Cliente,
        val pagamento: Pagamento,
        val valorTotal: Double,
        val produto: List<Produto>
){
    constructor(compra: Compra): this(
            cliente = compra.cliente,
            pagamento = compra.pagamento,
            valorTotal = compra.valorTotal,
            produto = compra.produto
    )
}
