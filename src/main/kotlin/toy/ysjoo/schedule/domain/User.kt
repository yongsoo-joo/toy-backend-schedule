package toy.ysjoo.schedule.domain

import toy.ysjoo.schedule.dto.UserDto

data class User(
    var id: Int = 0,
    var name: String? = null,
    var address: String? = null,
    val phoneNumber: String? = null,
    var role: String? = null
) {
    fun toUserDto(): UserDto {
        return UserDto(id, name, address, phoneNumber, role)
    }
}