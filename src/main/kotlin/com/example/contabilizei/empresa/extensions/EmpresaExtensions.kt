package com.example.contabilizei.empresa.extensions

import com.example.contabilizei.empresa.dto.EmpresaDTO
import com.example.contabilizei.empresa.entity.Empresa

fun Empresa.toDto() = EmpresaDTO(cnpj = cnpj, razaoSocial = razaoSocial)