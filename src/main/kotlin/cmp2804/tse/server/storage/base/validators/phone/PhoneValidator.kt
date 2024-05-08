package cmp2804.tse.server.storage.base.validators.phone

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

/**
 * Validator to ensure that a given string is a valid UK phone number
 *
 * @author Ben Soones
 */
class PhoneValidator : ConstraintValidator<Phone, String> {

    /**
     * Regex for valid phone number
     */
    private val phoneRegex = "(?:\\+44|0) ?(?:\\d{3} ?\\d{3} ?\\d{4}|\\d{4} ?\\d{3} ?\\d{3}|\\d{2} ?\\d{4} ?\\d{4}|\\d{4}-\\d{3}-\\d{3})".toRegex()

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return true
        return phoneRegex.matches(value)
    }
}