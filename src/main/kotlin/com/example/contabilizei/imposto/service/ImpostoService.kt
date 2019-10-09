package com.example.contabilizei.imposto.service

import com.example.contabilizei.empresa.exception.EmpresaNotFoundException
import com.example.contabilizei.empresa.service.EmpresaService
import com.example.contabilizei.imposto.dto.ImpostoDTO
import com.example.contabilizei.imposto.model.Imposto
import com.example.contabilizei.imposto.repository.ImpostoRepository
import com.example.contabilizei.utils.toDateBR
import org.springframework.stereotype.Service

@Service
class ImpostoService(private val impostoRepository: ImpostoRepository,
                     private val empresaService: EmpresaService) {

    fun create(impostoDTO: ImpostoDTO): Imposto? {

        val empresa = empresaService.findById(impostoDTO.empresaCnpj)
                ?: throw EmpresaNotFoundException("Empresa com cnpj ${impostoDTO.empresaCnpj} não foi encontrada!")

        val imposto = Imposto(tipo = impostoDTO.tipo, valor = impostoDTO.valor, vencimento = impostoDTO.vencimento.toDateBR())
        imposto.empresa = empresa

        return impostoRepository.save(imposto)
    }

    fun findById(id: Long): Imposto? {
        return impostoRepository.findById(id).orElse(null)
    }

}
