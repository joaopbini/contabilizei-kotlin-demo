package com.example.contabilizei.empresa.model

import com.example.contabilizei.audit.AuditModel
import com.example.contabilizei.imposto.model.Imposto
import javax.persistence.*

@Entity
data class Empresa(

        @Id
        val cnpj: String = "",

        val razaoSocial: String = ""

) : AuditModel() {

    @OneToMany(mappedBy = "empresa", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    lateinit var impostos: List<Imposto>

}
