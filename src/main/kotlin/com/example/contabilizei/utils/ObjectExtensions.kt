package com.example.contabilizei.utils

import com.fasterxml.jackson.databind.ObjectMapper

fun <T : Any> T?.notNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}

fun <T : Any> T.toJsonString(): String = ObjectMapper().writeValueAsString(this)
