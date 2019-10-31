package com.example.contabilizei.imposto.repository

import com.example.contabilizei.empresa.entity.Empresa
import com.example.contabilizei.imposto.entity.Imposto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

interface ImpostoRepository : PagingAndSortingRepository<Imposto, Long> {

    fun findByEmpresa(empresa: Empresa, pageable: Pageable): Page<Imposto>

}