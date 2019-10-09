package com.example.contabilizei.imposto.dto

import java.math.BigDecimal

data class ImpostoDTO(

        val tipo: String = "",

        val valor: BigDecimal = BigDecimal.ZERO,

        val vencimento: String = "",

        val empresaCnpj: String = ""

)