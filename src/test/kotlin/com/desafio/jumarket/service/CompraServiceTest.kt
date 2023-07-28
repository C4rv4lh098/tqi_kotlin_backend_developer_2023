package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.entity.Cliente
import com.desafio.jumarket.entity.Compra
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.enummeration.Pagamento
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.CompraRepository
import com.desafio.jumarket.service.impl.CategoriaService
import com.desafio.jumarket.service.impl.ClienteService
import com.desafio.jumarket.service.impl.CompraService
import com.desafio.jumarket.service.impl.ProdutoService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CompraServiceTest{
    @MockK
    lateinit var compraRepository: CompraRepository

    @InjectMockKs
    lateinit var compraService: CompraService

    @Test
    fun `create compra`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)
        val fakeProduto: Produto = buildProduto(id = fakeId, categoria = fakeCategoria)
        val fakeCliente: Cliente = buildCliente(id = fakeId)
        val fakeCompra: Compra = buildCompra(cliente = fakeCliente, produto = mutableListOf(fakeProduto))

        every { compraRepository.save(fakeCompra) } returns fakeCompra
        //when
        val actual: Compra = this.compraService.save(fakeCompra)

        //then
        verify(exactly = 1) { compraRepository.save(fakeCompra) }

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCompra)
    }

    @Test
    fun `find compra by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)
        val fakeProduto: Produto = buildProduto(id = fakeId, categoria = fakeCategoria)
        val fakeCliente: Cliente = buildCliente(id = fakeId)
        val fakeCompra: Compra = buildCompra(id = fakeId, cliente = fakeCliente, produto = mutableListOf(fakeProduto))

        every { compraRepository.findById(fakeId) } returns Optional.of(fakeCompra)

        //when
        val actual: Compra = this.compraService.findById(fakeId)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Compra::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCompra)
        verify(exactly = 1) { compraRepository.findById(fakeId) }
    }

    @Test
    fun `not find compra by invalid id and throw BusinessException`(){
        //given
        val fakeId: Long = Random().nextLong()

        every { compraRepository.findById(fakeId) } returns Optional.empty()

        //when
        //then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
                .isThrownBy { compraService.findById(fakeId) }
                .withMessage("Compra $fakeId not found")
        verify(exactly = 1) { compraRepository.findById(fakeId) }
    }

    @Test
    fun `delete compra by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)
        val fakeProduto: Produto = buildProduto(id = fakeId, categoria = fakeCategoria)
        val fakeCliente: Cliente = buildCliente(id = fakeId)
        val fakeCompra: Compra = buildCompra(id = fakeId, cliente = fakeCliente, produto = mutableListOf(fakeProduto))

        every { compraRepository.findById(fakeId) } returns Optional.of(fakeCompra)
        every { compraRepository.delete(fakeCompra) } just runs

        //when
        compraService.delete(fakeId)

        //then
        verify(exactly = 1) { compraRepository.findById(fakeId) }
        verify(exactly = 1) { compraRepository.delete(fakeCompra) }
    }

    companion object{
        fun buildCategoria(
                id: Long? = null,
                nome: String = "Bebida"
        ) = Categoria(
                id = id,
                nome = nome
        )

        private fun buildProduto(
                id: Long? = null,
                nome: String = "Coca - Cola",
                unidadeMedida: String = "Litro",
                preco: Double = 6.0,
                categoria: Categoria = buildCategoria()
        ) = Produto(
                id = id,
                nome = nome,
                unidadeMedida = unidadeMedida,
                preco = preco,
                categoria = categoria
        )

        fun buildCliente(
                id: Long? = null,
                nome: String = "Rodrigo"
        ) = Cliente(
                id = id,
                nome = nome
        )

        fun buildCompra(
                id: Long? = null,
                cliente: Cliente = buildCliente(),
                pagamento: Pagamento = Pagamento.DEBITO,
                valorTotal: Double = 25.0,
                produto: List<Produto>
        ) = Compra(
                id = id,
                cliente = cliente,
                pagamento = pagamento,
                valorTotal = valorTotal,
                produto = produto
        )

    }
}
