package toy.ysjoo.schedule.mapper

import org.mapstruct.*
import toy.ysjoo.schedule.domain.Schedule
import toy.ysjoo.schedule.dto.ScheduleDto

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ScheduleMapper {
    fun toDto(schdule: Schedule): ScheduleDto
    fun toDomain(schduleDto: ScheduleDto): Schedule

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun update(schduleDto: ScheduleDto, @MappingTarget schdule: Schedule)
}