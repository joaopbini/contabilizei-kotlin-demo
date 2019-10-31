package com.example.contabilizei.notafiscal.dto

import com.example.contabilizei.notafiscal.model.enumeration.StatusNotaFiscal
import java.math.BigDecimal
import java.util.*

data class NotaFiscalDTO(

        val valor: BigDecimal = BigDecimal.ZERO,

        val cnpj: String = "",

        val dataEmissao: Date = Date(),

        val status: StatusNotaFiscal = StatusNotaFiscal.EMITIDA

)