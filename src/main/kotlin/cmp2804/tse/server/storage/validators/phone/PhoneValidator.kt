package cmp2804.tse.server.storage.validators.phone

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PhoneValidator : ConstraintValidator<Phone, String> {

    private val phoneRegex = "(?:\\+44|0) ?(?:\\d{3} ?\\d{3} ?\\d{4}|\\d{4} ?\\d{3} ?\\d{3}|\\d{2} ?\\d{4} ?\\d{4})".toRegex()

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return true // Consider null values as valid
        return phoneRegex.matches(value)
    }
}