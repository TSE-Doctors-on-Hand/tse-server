package cmp2804.tse.server.storage.base.validators.pasttimestamp

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PastTimestampValidator::class])
annotation class PastTimestamp(
    val message: String = "Must be a time in the past",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)