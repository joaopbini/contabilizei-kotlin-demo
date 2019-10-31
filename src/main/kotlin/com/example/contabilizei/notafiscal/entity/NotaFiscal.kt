package com.example.contabilizei.notafiscal.entity

import com.example.contabilizei.audit.AuditModel
import com.example.contabilizei.empresa.entity.Empresa
import com.example.contabilizei.notafiscal.model.enumeration.StatusNotaFiscal
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
data class NotaFiscal(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        val valor: BigDecimal = BigDecimal.ZERO,

        @Temporal(TemporalType.TIMESTAMP)
        val dataEmissao: Date = Date(),

        val status: StatusNotaFiscal = StatusNotaFiscal.EMITIDA

) : AuditModel() {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empresa_cnpj", nullable = false)
    @JsonIgnore
    lateinit var empresa: Empresa

    constructor(valor: BigDecimal, dataEmissao: Date, status: StatusNotaFiscal, empresa: Empresa) : this(valor = valor,
            dataEmissao = dataEmissao,
            status = status) {
        this.empresa = empresa
    }

}
