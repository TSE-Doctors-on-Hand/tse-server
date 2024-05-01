package cmp2804.tse.server.util.error

import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


/**
 * Global exception handler
 *
 * @author Ben Soones
 */
@RestControllerAdvice
object GlobalExceptionHandler {

    /**
     * Exception handler for invalid method arguments
     *
     * @author Ben Soones
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<String> {
        val errors = e.bindingResult
            ?.fieldErrors
            ?.joinToString(", ") {
                "${it.field}: ${it.defaultMessage}"
            } ?: "Unknown error"

        return ResponseEntity.badRequest().body(errors)
    }

    /**
     * Exception handler for entities that are not present
     * in the database
     *
     * @see EntityNotFoundException
     */
    @ExceptionHandler(EntityNotFoundException::class)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                e.message ?: "Resource not found"
            )
    }
}