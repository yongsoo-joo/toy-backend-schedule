package toy.ysjoo.schedule.service

import org.springframework.stereotype.Service
import toy.ysjoo.schedule.database.ScheduleDatabaseImpl
import toy.ysjoo.schedule.dto.ScheduleDto
import javax.transaction.Transactional


@Service
class ScheduleServiceMemoryImpl(
    private val db: ScheduleDatabaseImpl = ScheduleDatabaseImpl()
) : RestService<ScheduleDto> {

    /**
     *
     */
    override fun add(e: ScheduleDto): Long {
        return db.add(e.toSchedule())
    }

    /**
     *
     */
    @Transactional
    override fun update(e: ScheduleDto): Boolean {
        return db.update(e.toSchedule())
    }

    /**
     *
     */
    override fun get(id: Long): ScheduleDto? {
        val schedule = db.search(id)
        return when (schedule != null) {
            true -> schedule.toScheduleDto()
            false -> null
        }
    }

    /**
     *
     */
    override fun getAll(): List<ScheduleDto> {
        val scheduleDtoList = mutableListOf<ScheduleDto>()
        db.searchAll().forEach {
            scheduleDtoList.add(it.toScheduleDto())
        }
        return scheduleDtoList
    }

    /**
     *
     */
    override fun delete(id: Long): Boolean {
        return db.delete(id)
    }
}