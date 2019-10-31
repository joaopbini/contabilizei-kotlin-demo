package com.example.contabilizei.template

import com.example.contabilizei.empresa.entity.Empresa

fun createEmpresa(cnpj: String = "19322789000125",
                  razaoSocial: String = "Contabilizei Contabilidade") = Empresa(cnpj = cnpj,
        razaoSocial = razaoSocial)