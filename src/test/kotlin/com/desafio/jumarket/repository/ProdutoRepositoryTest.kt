package com.desafio.jumarket.repository

import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.entity.Produto
import com.desafio.jumarket.service.ProdutoServiceTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProdutoRepositoryTest {
    @Autowired lateinit var produtoRepository: ProdutoRepository
    @Autowired lateinit var testEntityManager: TestEntityManager

    private lateinit var categoria: Categoria
    private lateinit var produto: Produto
    private lateinit var produto2: Produto
    private lateinit var produto3: Produto

    @BeforeEach fun setup(){
        categoria = testEntityManager.persist(buildCategoria())
        produto = testEntityManager.persist(buildProduto(categoria = categoria))
        produto2 = testEntityManager.persist(buildProduto(categoria = categoria))
        produto3 = testEntityManager.persist(buildProduto(categoria = categoria))
    }

    @Test
    fun `find all produto by categoria id`(){
        //given
        val categoriaId: Long = 1L
        //when
        val produtoList: List<Produto> = produtoRepository.findAllByCategoriaId(categoriaId)
        //then
        Assertions.assertThat(produtoList).isNotEmpty
        Assertions.assertThat(produtoList.size).isEqualTo(3)
        Assertions.assertThat(produtoList).contains(produto, produto2, produto3)
    }

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