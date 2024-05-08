package cmp2804.tse.server.util.error

import cmp2804.tse.server.util.error.errors.EntityNotFoundException
import cmp2804.tse.server.util.error.errors.UnauthorisedException
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
class GlobalExceptionHandler {

    /**
     * Exception handler for invalid method arguments
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<List<String>> {
        val errors = e.bindingResult
            ?.fieldErrors
            ?.map { "${it.field} ${it.defaultMessage}" }
            ?: listOf("Unknown error")

        return ResponseEntity.badRequest().body(errors)
    }

    /**
     * Exception handler for entities that are not present
     * in the database
     *
     * @see EntityNotFoundException
     */
    @ExceptionHandler(EntityNotFoundException::class)
    fun handleNotFoundException(e: EntityNotFoundException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                e.message ?: "Resource not found"
            )
    }

    /**
     * Exception handler for unauthorised requests
     *
     * @see UnauthorisedException
     */
    @ExceptionHandler(UnauthorisedException::class)
    fun handleUnauthorisedException(e: UnauthorisedException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body(
                e.message ?: "You are not authorised to perform this action"
            )
    }

    /**
     * Umbrella handler for all other errors
     *
     * @see Exception
     */
    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                e.message ?: "Unexpected error"
            )
    }

}