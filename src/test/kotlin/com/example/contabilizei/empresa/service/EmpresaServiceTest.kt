package com.example.contabilizei.empresa.service

import com.example.contabilizei.empresa.dto.EmpresaDTO
import com.example.contabilizei.empresa.extensions.toDto
import com.example.contabilizei.empresa.model.Empresa
import com.example.contabilizei.empresa.repository.EmpresaRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
class EmpresaServiceTest {

    private val empresaRepository: EmpresaRepository = mockk()

    private val empresaService = EmpresaService(empresaRepository)

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }


    @Test
    fun create() {

        val empresaDto = EmpresaDTO(cnpj = "1", razaoSocial = "Razão Social")

        val empresaEsperada = Empresa(cnpj = "1", razaoSocial = "Razão Social")

        every { empresaRepository.findByCnpj(any()) } returns null

        every { empresaRepository.save(any<Empresa>()) } returns empresaEsperada

        val empresaCriada = empresaService.create(empresaDto)

        assertEquals(empresaDto, empresaCriada)

    }

    @Test
    fun findByCnpj() {

        val empresaEsperada = EmpresaDTO(cnpj = "1", razaoSocial = "Razão Social")

        every { empresaRepository.findByCnpj(any()) } returns empresaEsperada

        val empresaDto = empresaService.findByCnpj("1")

        assertEquals(empresaEsperada, empresaDto)

    }

    @Test
    fun findById() {

        val empresaEsperada = Optional.of((Empresa(cnpj = "1", razaoSocial = "Razão Social")))

        every { empresaRepository.findById(any()) } returns empresaEsperada

        val empresa = empresaService.findById("1")

        assertEquals(empresaEsperada.get(), empresa)

    }
}