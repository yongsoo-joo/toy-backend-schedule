package toy.ysjoo.schedule.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import toy.ysjoo.schedule.domain.Schedule

@Repository
interface ScheduleRepository : JpaRepository<Schedule, Long>, ScheduleQuerydslRepository