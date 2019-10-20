package com.example.contabilizei.imposto.repository

import com.example.contabilizei.empresa.model.Empresa
import com.example.contabilizei.imposto.model.Imposto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

interface ImpostoRepository : PagingAndSortingRepository<Imposto, Long> {

    fun findByEmpresa(empresa: Empresa, pageable: Pageable): Page<Imposto>

}