package toy.ysjoo.schedule.dto

import toy.ysjoo.schedule.domain.Schedule

data class ScheduleDto(
    var id: Int = 0,
    var title: String? = null,
    var contents: String? = null,
    var location: String? = null,
    var startdate: String? = null,
    var enddate: String? = null,
    var owner: Int = 0,
    var attendees: List<Int>? = null
) {
    fun toSchedule(): Schedule {
        return Schedule(id, title, contents, location, startdate, enddate, owner, attendees)
    }
}