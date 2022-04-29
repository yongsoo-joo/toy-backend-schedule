package toy.ysjoo.schedule.dto

import toy.ysjoo.schedule.domain.User

data class UserDto(
    val id: Int = 0,
    val name: String? = null,
    val address: String? = null,
    val phoneNumber: String? = null,
    val role: String? = null
) {
    fun toUser(): User {
        return User(id, name, address, phoneNumber, role)
    }
}