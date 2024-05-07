package cmp2804.tse.server.storage.base.validators.pasttimestamp

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PastTimestampValidator : ConstraintValidator<PastTimestamp, Long> {
    override fun isValid(value: Long?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return true // Consider null values as valid
        return value < System.currentTimeMillis() // Validate if it's in the future
    }
}