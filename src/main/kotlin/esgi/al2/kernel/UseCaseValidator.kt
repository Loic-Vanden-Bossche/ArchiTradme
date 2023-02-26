package esgi.al2.kernel;

import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory

class UseCaseValidator private constructor(validator: Validator) {
    private val validator: Validator

    init {
        this.validator = validator
    }

    fun validator(): Validator {
        return validator
    }

    companion object {
        private var INSTANCE: UseCaseValidator? = null
        private fun create(): UseCaseValidator {
            val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
            val validator: Validator = factory.validator
            return UseCaseValidator(validator)
        }

        val instance: UseCaseValidator
            get() {
                if (INSTANCE == null) {
                    INSTANCE = create()
                }
                return INSTANCE as UseCaseValidator
            }
    }
}
