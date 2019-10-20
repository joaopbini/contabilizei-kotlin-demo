package com.example.contabilizei.utils

object ExceptionMessageUtil {

    fun getMessageErro(e: Exception): String {
        return e.message ?: e.javaClass.simpleName
    }

}
