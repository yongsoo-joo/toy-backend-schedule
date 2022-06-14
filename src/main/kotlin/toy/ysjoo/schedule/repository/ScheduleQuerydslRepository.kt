package toy.ysjoo.schedule.repository

import toy.ysjoo.schedule.domain.Schedule

interface ScheduleQuerydslRepository {
    fun search(title: String): Schedule?
}