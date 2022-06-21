package toy.ysjoo.schedule.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserDto(
    var id: Long = 0,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null
)