package toy.ysjoo.schedule.mapper

import org.mapstruct.*
import toy.ysjoo.schedule.domain.User
import toy.ysjoo.schedule.dto.UserDto

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper {
    fun toDto(user: User): UserDto
    fun toDomain(userDto: UserDto): User

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun update(userDto: UserDto, @MappingTarget user: User)
}