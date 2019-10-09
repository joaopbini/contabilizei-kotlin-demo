package com.example.contabilizei.empresa.model

import com.example.contabilizei.audit.AuditModel
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Empresa(

        @Id
        val cnpj: String = "",

        val razaoSocial: String = ""

) : AuditModel()
