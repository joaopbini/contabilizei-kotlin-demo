package com.example.contabilizei

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class ContabilizeiApplication

fun main(args: Array<String>) {
	runApplication<ContabilizeiApplication>(*args)
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
}
