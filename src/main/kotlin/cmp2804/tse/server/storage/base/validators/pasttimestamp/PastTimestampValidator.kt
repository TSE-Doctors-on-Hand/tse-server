package cmp2804.tse.server.storage.base.validators.pasttimestamp

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

/**
 * Validator to ensure that a given unix timestamp Long is in the past
 *
 * @author Ben Soones
 */
class PastTimestampValidator : ConstraintValidator<PastTimestamp, Long> {
    override fun isValid(value: Long?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return true // Null values are valid
        return value < System.currentTimeMillis()
    }
}