package esgi.al2.kernel

import jakarta.validation.*
import jakarta.validation.constraints.Pattern
import kotlin.reflect.KClass

class IsUUIDValidator : ConstraintValidator<IsUUID, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        println("IsUUIDValidator.isValid($value)")
        if (value == null) {
            return true // null values should be validated separately with @NotNull constraint
        }
        val pattern = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$"
        return value.matches(Regex(pattern))
    }
}

@Target(AnnotationTarget.VALUE_PARAMETER)
@Constraint(validatedBy = [IsUUIDValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
@ReportAsSingleViolation
annotation class IsUUID(
    val message: String = "{invalid.uuid}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

//@Target(ElementType.FIELD)
//@Constraint(validatedBy = [])
//@Retention(RUNTIME)
//@ReportAsSingleViolation
//annotation class UUID(
//    val message: String = "{invalid.uuid}",
//    val groups: Array<KClass<*>> = [],
//    val payload: Array<KClass<out Payload?>> = []
//)