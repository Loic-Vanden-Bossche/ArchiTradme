package esgi.al2.kernel

import java.util.*

class IsUUIDValidator {
    fun isValid(value: String?): Boolean {
        if (value == null) {
            return true // null values are allowed
        }
        return try {
            UUID.fromString(value)
            true
        } catch (ex: IllegalArgumentException) {
            false
        }
    }
}