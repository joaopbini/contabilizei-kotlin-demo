package com.example.contabilizei.notafiscal.repository

import com.example.contabilizei.empresa.entity.Empresa
import com.example.contabilizei.notafiscal.entity.NotaFiscal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface NotaFiscalRepository : CrudRepository<NotaFiscal, Long> {

    fun findByEmpresa(empresa: Empresa, pageable: Pageable): Page<NotaFiscal>

}
