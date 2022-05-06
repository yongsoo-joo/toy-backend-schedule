package toy.ysjoo.schedule.domain

import toy.ysjoo.schedule.dto.ScheduleDto

data class Schedule(
    var id: Int = 0,
    var title: String? = null,
    var contents: String? = null,
    var location: String? = null,
    var startdate: String? = null,
    var enddate: String? = null,
    var owner: Int = 0,
    var attendees: List<Int>? = null
) {
    fun toScheduleDto(): ScheduleDto {
        return ScheduleDto(id, title, contents, location, startdate, enddate, owner, attendees)
    }

}