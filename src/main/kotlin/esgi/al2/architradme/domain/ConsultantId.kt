package esgi.al2.architradme.domain

import java.util.*

class ConsultantId(private val value: UUID) {
    fun value(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val accountId: ConsultantId = other as ConsultantId
        return value == accountId.value
    }

    override fun hashCode(): Int {
        return Objects.hash(value)
    }

    override fun toString(): String {
        return "AccountId{" +
                "value='" + value + '\'' +
                '}'
    }

    companion object {
        fun of(value: UUID): ConsultantId {
            return ConsultantId(value)
        }
    }
}