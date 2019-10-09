package com.example.contabilizei.imposto.api

import com.example.contabilizei.imposto.dto.ImpostoDTO
import com.example.contabilizei.imposto.service.ImpostoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("imposto")
class ImpostoApi(private val impostoService: ImpostoService) {

    @PostMapping("/")
    fun createImposto(@RequestBody impostoDTO: ImpostoDTO) = impostoService.create(impostoDTO)


    @GetMapping("/{id}")
    fun getImposto(@PathVariable("id") id: Long) = impostoService.findById(id)

}
