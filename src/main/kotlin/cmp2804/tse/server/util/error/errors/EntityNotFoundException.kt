package cmp2804.tse.server.util.error.errors

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception can be called whenever a request is made to a database
 * where expected data is not present.
 *
 * @author Ben Soones
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
class EntityNotFoundException(message: String? = null): Exception(message)