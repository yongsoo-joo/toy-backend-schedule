package toy.ysjoo.schedule.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import toy.ysjoo.schedule.domain.QSchedule
import toy.ysjoo.schedule.domain.Schedule

class ScheduleQuerydslRepositoryImpl(
    private val query: JPAQueryFactory
) : QuerydslRepositorySupport(Schedule::class.java), ScheduleQuerydslRepository {
    override fun search(title: String): Schedule? {
        return query.selectFrom(QSchedule.schedule).where(QSchedule.schedule.title.eq(title)).fetchOne()
    }
}