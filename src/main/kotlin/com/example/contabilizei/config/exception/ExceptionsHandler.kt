package com.example.contabilizei.config.exception

import com.example.contabilizei.config.exception.dto.ErrorDto
import com.example.contabilizei.config.exception.dto.ValidationValidDTO
import com.example.contabilizei.utils.ExceptionMessageUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Level
import java.util.logging.Logger
import javax.servlet.http.HttpServletRequest

@ControllerAdvice(annotations = [RestController::class])
class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(request: HttpServletRequest, e: MethodArgumentNotValidException): ResponseEntity<ValidationValidDTO> {

        LOGGER.log(Level.SEVERE, e.message, e)

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ValidationValidDTO("Erro de validação!", e.bindingResult.fieldErrors))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(request: HttpServletRequest, e: Exception): ResponseEntity<ErrorDto> {

        LOGGER.log(Level.SEVERE, e.message, e)

        val msgErro = ExceptionMessageUtil.getMessageErro(e)

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto(msgErro))
    }

    companion object {
        private val LOGGER = Logger.getLogger(ExceptionsHandler::class.java.name)
    }

}
