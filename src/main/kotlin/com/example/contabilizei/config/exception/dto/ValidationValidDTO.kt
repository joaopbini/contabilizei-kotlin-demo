package com.example.contabilizei.config.exception.dto


import org.springframework.validation.FieldError
import java.util.*

class ValidationValidDTO(message: String, fieldErrors: List<FieldError>) {

    var message: String? = null

    var fieldErrors: List<FieldDTO>? = null

    init {
        prepare(message, fieldErrors)
    }

    private fun prepare(message: String, fieldErrorList: List<FieldError>) {

        val fieldErrorsList = ArrayList<FieldDTO>()

        for (fieldError in fieldErrorList) {
            val field = FieldDTO(fieldError.field, fieldError.defaultMessage!!)
            fieldErrorsList.add(field)
        }

        this.message = message
        this.fieldErrors = fieldErrorsList

    }

}
