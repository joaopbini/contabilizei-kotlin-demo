package com.example.contabilizei.notafiscal.api

import com.example.contabilizei.notafiscal.dto.NotaFiscalDTO
import com.example.contabilizei.notafiscal.service.NotaFiscalService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/nota-fiscal")
class NotaFiscalApi(private val notaFiscalService: NotaFiscalService) {

    @PostMapping("/")
    fun createNota(@RequestBody notaFiscalDTO: NotaFiscalDTO) = notaFiscalService.create(notaFiscalDTO)


    @GetMapping("/{id}")
    fun getNota(@PathVariable("id") id: Long) = notaFiscalService.findById(id)

    @GetMapping("list/{cnpj}")
    fun getNotas(@PathVariable("cnpj") cnpj: String,
                 @RequestParam(required = false, defaultValue = "0") page: Int,
                 @RequestParam(required = false, defaultValue = "20") size: Int) = notaFiscalService.list(cnpj, page, size)

}
