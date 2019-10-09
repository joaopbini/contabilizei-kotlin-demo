package com.example.contabilizei.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.toDateBR(): Date {
    val formato = SimpleDateFormat("dd/MM/yyyy")
    return formato.parse(this)
}
