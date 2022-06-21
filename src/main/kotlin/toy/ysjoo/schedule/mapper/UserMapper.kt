package toy.ysjoo.schedule.mapper

import org.mapstruct.*
import toy.ysjoo.schedule.domain.User
import toy.ysjoo.schedule.dto.UserDto

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper {

    @Mappings(
        Mapping(source = "m_password", target = "password"),
    )
    fun toDto(user: User): UserDto

    @Mappings(
        Mapping(source = "password", target = "m_password"),
    )
    fun toDomain(userDto: UserDto): User

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun update(userDto: UserDto, @MappingTarget user: User)
}