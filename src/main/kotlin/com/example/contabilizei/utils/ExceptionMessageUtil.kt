package com.example.contabilizei.utils

class ExceptionMessageUtil {

    companion object {
        fun getMessageErro(e: Exception): String {
            return e.message ?: e.javaClass.simpleName
        }
    }

}
