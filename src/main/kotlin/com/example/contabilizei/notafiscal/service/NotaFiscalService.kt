package com.example.contabilizei.notafiscal.service

import com.example.contabilizei.empresa.exception.EmpresaNotFoundException
import com.example.contabilizei.empresa.service.EmpresaService
import com.example.contabilizei.notafiscal.dto.NotaFiscalDTO
import com.example.contabilizei.notafiscal.entity.NotaFiscal
import com.example.contabilizei.notafiscal.repository.NotaFiscalRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class NotaFiscalService(private val notaFiscalRepository: NotaFiscalRepository,
                        private val empresaService: EmpresaService) {

    fun create(notaFiscalDTO: NotaFiscalDTO): NotaFiscal {

        val empresa = empresaService.findById(notaFiscalDTO.cnpj)
                ?: throw EmpresaNotFoundException("Empresa com cnpj ${notaFiscalDTO.cnpj} não foi encontrada!")


        val notaFiscal = with(notaFiscalDTO) {
            NotaFiscal(valor = valor,
                    dataEmissao = dataEmissao,
                    status = status,
                    empresa = empresa)
        }

        return notaFiscalRepository.save(notaFiscal)
    }

    fun findById(id: Long): NotaFiscal {
        return notaFiscalRepository.findById(id).orElse(null)
    }

    fun list(cnpj: String, page: Int, size: Int): Page<NotaFiscal> {

        val empresa = empresaService.findById(cnpj) ?: throw EmpresaNotFoundException("Empresa $cnpj não encontrada!")

        return notaFiscalRepository.findByEmpresa(empresa, PageRequest.of(page, size))
    }

}
