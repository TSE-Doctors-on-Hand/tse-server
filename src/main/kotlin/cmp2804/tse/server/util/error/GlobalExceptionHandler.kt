package cmp2804.tse.server.util.error

import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
object GlobalExceptionHandler {

    /**
     * Exception handler for invalid method arguments
     *
     * @author Ben Soones
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(e: MethodArgumentNotValidException): ResponseEntity<String> {
        val errors = e.bindingResult?.fieldErrors?.joinToString(", ") {
            "${it.field}: ${it.defaultMessage}"
        } ?: "Unknown error"
        return ResponseEntity.badRequest().body(errors)
    }
}