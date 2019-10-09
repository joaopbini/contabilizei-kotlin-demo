package com.example.contabilizei.imposto.model

import com.example.contabilizei.audit.AuditModel
import com.example.contabilizei.empresa.model.Empresa
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
data class Imposto(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        val tipo: String = "",

        val valor: BigDecimal = BigDecimal.ZERO,

        @Temporal(TemporalType.DATE)
        val vencimento: Date = Date()


) : AuditModel() {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empresa_cnpj", nullable = false)
    @JsonIgnore
    lateinit var empresa: Empresa

}