package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Categoria
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.CategoriaRepository
import com.desafio.jumarket.service.impl.CategoriaService
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CategoriaServiceTest {
    @MockK
    lateinit var categoriaRepository: CategoriaRepository

    @InjectMockKs
    lateinit var categoriaService: CategoriaService

    @Test
    fun `create categoria`(){
        //given
        val categoria: Categoria = buildCategoria()

        every { categoriaRepository.save(categoria) } returns categoria

        //when
        val actual: Categoria = this.categoriaService.save(categoria)

        //then
        verify(exactly = 1) { categoriaRepository.save(categoria) }

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(categoria)
    }

    @Test
    fun `find categoria by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)

        every { categoriaRepository.findById(fakeId) } returns Optional.of(fakeCategoria)
        //when
        val actual: Categoria = this.categoriaService.findById(fakeId)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Categoria::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCategoria)
        verify(exactly = 1) { categoriaRepository.findById(fakeId) }
    }

    @Test
    fun `not find categoria by invalid id and throw BussinessException`(){
        //given
        val fakeId: Long = Random().nextLong()
        every { categoriaRepository.findById(fakeId) } returns Optional.empty()
        //when
        //then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
                .isThrownBy { categoriaService.findById(fakeId) }
                .withMessage("Id $fakeId not found")
        verify(exactly = 1) { categoriaRepository.findById(fakeId) }
    }

    @Test
    fun `delete categoria by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCategoria: Categoria = buildCategoria(id = fakeId)
        every { categoriaRepository.findById(fakeId) } returns Optional.of(fakeCategoria)
        every { categoriaRepository.delete(fakeCategoria) } just runs
        //when
        categoriaService.delete(fakeId)
        //then
        verify (exactly = 1) { categoriaRepository.findById(fakeId) }
        verify (exactly = 1) { categoriaRepository.delete(fakeCategoria) }
    }

    companion object{
        fun buildCategoria(
                id: Long? = null,
                nome: String = "Bebida"
        ) = Categoria(
                id = id,
                nome = nome
        )
    }
}