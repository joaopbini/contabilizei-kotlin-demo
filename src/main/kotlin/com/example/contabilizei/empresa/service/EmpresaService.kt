package com.example.contabilizei.empresa.service

import com.example.contabilizei.empresa.dto.EmpresaDTO
import com.example.contabilizei.empresa.model.Empresa
import com.example.contabilizei.empresa.repository.EmpresaRepository
import org.springframework.stereotype.Service

@Service
class EmpresaService(private val empresaRepository: EmpresaRepository) {

    fun create(empresaDTO: EmpresaDTO): EmpresaDTO? {

        val empresa = Empresa(empresaDTO.cnpj, empresaDTO.razaoSocial)

        empresaRepository.save(empresa)

        return empresaDTO
    }

    fun findByCnpj(cnpj: String): EmpresaDTO? {
        return empresaRepository.findByCnpj(cnpj)
    }

}
