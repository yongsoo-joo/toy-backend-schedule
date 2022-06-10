package toy.ysjoo.schedule.service

import org.springframework.stereotype.Service
import toy.ysjoo.schedule.database.ScheduleDatabaseImpl
import toy.ysjoo.schedule.dto.ScheduleDto
import toy.ysjoo.schedule.mapper.ScheduleMapper
import javax.transaction.Transactional


@Service
class ScheduleServiceMemoryImpl(
    private val scheduleMapper: ScheduleMapper
) : RestService<ScheduleDto> {
    private val db: ScheduleDatabaseImpl = ScheduleDatabaseImpl()

    /**
     *
     */
    override fun add(e: ScheduleDto): Long {
        return db.add(scheduleMapper.toDomain(e))
    }

    /**
     *
     */
    @Transactional
    override fun update(e: ScheduleDto): Boolean {
        return db.update(scheduleMapper.toDomain(e))
    }

    /**
     *
     */
    override fun get(id: Long): ScheduleDto? {
        val schedule = db.search(id)
        return when (schedule != null) {
            true -> scheduleMapper.toDto(schedule)
            false -> null
        }
    }

    /**
     *
     */
    override fun getAll(): List<ScheduleDto> {
        val scheduleDtoList = mutableListOf<ScheduleDto>()
        db.searchAll().forEach {
            scheduleDtoList.add(scheduleMapper.toDto(it))
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