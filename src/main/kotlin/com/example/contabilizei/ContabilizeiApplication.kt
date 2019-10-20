package com.example.contabilizei

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.*

@SpringBootApplication
@EnableJpaAuditing
class ContabilizeiApplication

fun main(args: Array<String>) {
	runApplication<ContabilizeiApplication>(*args)
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
}

// todo exception handler
// notas fiscais
// calculo de faturamento
// calculo de imposto