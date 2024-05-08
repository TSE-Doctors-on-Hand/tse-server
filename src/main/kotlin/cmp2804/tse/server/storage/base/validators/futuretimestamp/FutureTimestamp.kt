package cmp2804.tse.server.storage.base.validators.futuretimestamp

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

/**
 * FutureTimestamp annotation
 *
 * Add this to timestamps that need to be in the future
 *
 * @author Ben Soones
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [FutureTimestampValidator::class])
annotation class FutureTimestamp(
    val message: String = "Must be a time in the future",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)