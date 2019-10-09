package com.example.contabilizei.empresa.api

import com.example.contabilizei.empresa.dto.EmpresaDTO
import com.example.contabilizei.empresa.service.EmpresaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/empresa")
class EmpresaApi(private val empresaService: EmpresaService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    fun createEmpresa(@Valid @RequestBody empresaDTO: EmpresaDTO): EmpresaDTO? {
        return empresaService.create(empresaDTO)
    }

    @GetMapping("/{cnpj}")
    fun getEmpresa(@PathVariable("cnpj") cnpj: String): EmpresaDTO? {
        return empresaService.findByCnpj(cnpj)
    }

}
