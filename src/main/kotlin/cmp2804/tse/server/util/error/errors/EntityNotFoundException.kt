package cmp2804.tse.server.util.error.errors

/**
 * Exception can be called whenever a request is made to a database
 * where expected data is not present.
 *
 * @author Ben Soones
 */
class EntityNotFoundException(message: String): Exception(message)