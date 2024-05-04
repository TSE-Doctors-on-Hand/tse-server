package cmp2804.tse.server.util.error.errors

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception can be called whenever a request is unauthorised
 *
 * @author Ben Soones
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
class UnauthorisedException(message: String): Exception(message)