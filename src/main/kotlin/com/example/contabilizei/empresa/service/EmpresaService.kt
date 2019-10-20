package com.example.contabilizei.empresa.service

import com.example.contabilizei.empresa.dto.EmpresaDTO
import com.example.contabilizei.empresa.exception.EmpresaJaCriadaException
import com.example.contabilizei.empresa.extensions.toDto
import com.example.contabilizei.empresa.model.Empresa
import com.example.contabilizei.empresa.repository.EmpresaRepository
import org.springframework.stereotype.Service

@Service
class EmpresaService(private val empresaRepository: EmpresaRepository) {

    fun create(empresaDTO: EmpresaDTO): EmpresaDTO? {

        empresaRepository.findByCnpj(empresaDTO.cnpj)?.let { throw EmpresaJaCriadaException("Empresa já cadastrada!") }

        val empresa = Empresa(empresaDTO.cnpj, empresaDTO.razaoSocial)

        return empresaRepository.save(empresa).toDto()
    }

    fun findByCnpj(cnpj: String): EmpresaDTO? {
        return empresaRepository.findByCnpj(cnpj)
    }

    fun findById(cnpj: String): Empresa? {
        return empresaRepository.findById(cnpj).orElse(null)
    }

}
