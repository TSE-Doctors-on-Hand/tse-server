package cmp2804.tse.server.storage.base.validators.phone

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

/**
 * Phone annotation
 *
 * Add this to strings that need to be a valid UK phone number
 *
 * @author Ben Soones
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PhoneValidator::class])
annotation class Phone(
    val message: String = "Must be a valid UK phone number",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)