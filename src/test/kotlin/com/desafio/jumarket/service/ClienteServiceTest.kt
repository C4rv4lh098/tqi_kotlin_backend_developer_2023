package com.desafio.jumarket.service

import com.desafio.jumarket.entity.Cliente
import com.desafio.jumarket.exception.BusinessException
import com.desafio.jumarket.repository.ClienteRepository
import com.desafio.jumarket.service.impl.ClienteService
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
class ClienteServiceTest {
    @MockK
    lateinit var clienteRepository: ClienteRepository

    @InjectMockKs
    lateinit var clienteService: ClienteService

    @Test
    fun`create cliente`(){
        //given
        val cliente: Cliente = buildCliente()

        every { clienteRepository.save(cliente) } returns cliente

        //when
        val actual: Cliente = this.clienteService.save(cliente)

        //then
        verify(exactly = 1) { clienteRepository.save(cliente) }

        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(cliente)
    }

    @Test
    fun `find cliente by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCliente: Cliente = buildCliente(id = fakeId)

        every { clienteRepository.findById(fakeId) } returns Optional.of(fakeCliente)
        //when
        val actual: Cliente = this.clienteService.findById(fakeId)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Cliente::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCliente)
        verify(exactly = 1) { clienteRepository.findById(fakeId) }
    }

    @Test
    fun `not find cliente by invalid id and throw BusinessException`(){
        //given
        val fakeId: Long = Random().nextLong()
        every { clienteRepository.findById(fakeId) } returns Optional.empty()
        //when
        //then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
                .isThrownBy { clienteService.findById(fakeId) }
                .withMessage("Id $fakeId not found")
        verify(exactly = 1) { clienteRepository.findById(fakeId) }
    }

    @Test
    fun `delete cliente by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCliente: Cliente = buildCliente(id = fakeId)
        every { clienteRepository.findById(fakeId) } returns Optional.of(fakeCliente)
        every { clienteRepository.delete(fakeCliente) } just runs

        //when
        clienteService.delete(fakeId)

        //then
        verify(exactly = 1) { clienteRepository.findById(fakeId) }
        verify(exactly = 1) { clienteRepository.delete(fakeCliente) }
    }

    companion object{
        fun buildCliente(
                id: Long? = null,
                nome: String = "Rodrigo"
        ) = Cliente(
                id = id,
                nome = nome
        )
    }
}