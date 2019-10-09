package com.example.contabilizei.empresa.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.validator.constraints.br.CNPJ

@JsonIgnoreProperties(ignoreUnknown = true)
data class EmpresaDTO(

        @get:CNPJ
        val cnpj: String = "",

        val razaoSocial: String = ""

)
