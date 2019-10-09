package com.example.contabilizei.empresa.repository

import com.example.contabilizei.empresa.dto.EmpresaDTO
import com.example.contabilizei.empresa.model.Empresa
import org.springframework.data.repository.CrudRepository

interface EmpresaRepository : CrudRepository<Empresa, String> {

    fun findByCnpj(cnpj: String) : EmpresaDTO?

}
