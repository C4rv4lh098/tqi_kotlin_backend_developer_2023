package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.CategoriaRepository
import com.desafio.jumarket.repository.ProdutoRepository
import com.desafio.jumarket.service.impl.CategoriaService
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
class ProdutoServiceTest {
    @MockK
    lateinit var produtoRepository: ProdutoRepository

    @MockK
    lateinit var categoriaService: CategoriaService

    @InjectMockKs
    lateinit var produtoService: ProdutoService

    @Test
    fun `create produto`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)
        val produto: Produto = buildProduto(categoria = fakeCategoria)

        every { categoriaService.findById(fakeId) } returns produto.categoria
        every { produtoRepository.save(produto) } returns produto

        //when
        val actual: Produto = this.produtoService.save(produto)

        //then
        verify(exactly = 1) { categoriaService.findById(fakeId) }
        verify(exactly = 1) { produtoRepository.save(produto) }

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(produto)
    }

    @Test
    fun `find produto by id`(){
        //given
        val findId: Long = 1L
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)
        val produto: Produto = buildProduto(id = findId,categoria = fakeCategoria)

        every { produtoRepository.findById(findId) } returns Optional.of(produto)

        //when
        val actual: Produto = this.produtoService.findById(findId)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Produto::class.java)
        Assertions.assertThat(actual).isSameAs(produto)
        verify(exactly = 1) { produtoRepository.findById(findId) }
    }

    @Test
    fun `not find produto by invalid id and throw BusinessException`(){
        //given
        val fakeId: Long = Random().nextLong()

        every { produtoRepository.findById(fakeId) } returns Optional.empty()

        //when
        //then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
                .isThrownBy { produtoService.findById(fakeId) }
                .withMessage("Id $fakeId not found")
        verify(exactly = 1) { produtoRepository.findById(fakeId) }
    }

    @Test
    fun `delete produto by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)
        val produto: Produto = buildProduto(id = fakeId, categoria = fakeCategoria)

        every { produtoRepository.findById(fakeId) } returns Optional.of(produto)
        every { produtoRepository.delete(produto) } just runs

        //when
        produtoService.delete(fakeId)

        //then
        verify(exactly = 1) { produtoRepository.findById(fakeId) }
        verify(exactly = 1) { produtoRepository.delete(produto) }
    }

    companion object{
        private fun buildCategoria(
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
    }
}