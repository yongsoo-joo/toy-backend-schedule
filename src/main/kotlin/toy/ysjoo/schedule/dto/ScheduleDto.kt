package toy.ysjoo.schedule.dto

import toy.ysjoo.schedule.domain.Schedule

data class ScheduleDto(
    var id: Long = 0,
    var title: String? = null,
    var contents: String? = null,
    var location: String? = null,
    var startdate: String? = null,
    var enddate: String? = null,
    var owner: Long = 0,
    var attendees: MutableList<Long>
) {
    fun toSchedule(): Schedule {
        return Schedule(id, title, contents, location, startdate, enddate, owner, attendees)
    }
}