package toy.ysjoo.schedule.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import toy.ysjoo.schedule.domain.User

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserDto(
    val id: Long = 0,
    val name: String? = null,
    val address: String? = null,
    val phoneNumber: String? = null,
    val role: String? = null
) {
    fun toUser(): User {
        return User(id, name, address, phoneNumber, role)
    }
}