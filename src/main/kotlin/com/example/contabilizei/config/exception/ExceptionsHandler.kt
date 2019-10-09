//package com.example.contabilizei.config.exception
//
//import com.example.contabilizei.utils.ExceptionMessageUtil
//import org.springframework.http.HttpHeaders
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.ControllerAdvice
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.bind.annotation.RestController
//import java.util.logging.Level
//import java.util.logging.Logger
//import javax.servlet.http.HttpServletRequest
//
//@ControllerAdvice(annotations = [RestController::class])
//class ExceptionsHandler {
//
//    @ExceptionHandler(Exception::class)
//    fun handleException(request: HttpServletRequest, e: Exception): ResponseEntity<*> {
//
//        LOGGER.log(Level.SEVERE, e.message, e)
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(getHeadersTextPlain()).body(ExceptionMessageUtil.getMessageErro(e))
//
//    }
//
//    private fun getHeadersTextPlain(): HttpHeaders {
//        val headers = HttpHeaders()
//        headers.add(HttpHeaders.CONTENT_TYPE, TEXT_PLAIN_UTF_8)
//        return headers
//    }
//
//    companion object {
//        private const val TEXT_PLAIN_UTF_8 = "text/plain;charset=UTF-8"
//        private val LOGGER = Logger.getLogger(ExceptionsHandler::class.java.name)
//    }
//
//
//}
