package toy.ysjoo.schedule.service

import toy.ysjoo.schedule.database.ScheduleDatabaseImpl
import toy.ysjoo.schedule.dto.ScheduleDto

class ScheduleServiceImpl(
    private val db: ScheduleDatabaseImpl = ScheduleDatabaseImpl()
) : RestService<ScheduleDto> {

    /**
     *
     */
    override fun add(e: ScheduleDto): Int {
        return db.add(e.toSchedule())
    }

    /**
     *
     */
    override fun update(e: ScheduleDto): Boolean {
        return db.update(e.toSchedule())
    }

    /**
     *
     */
    override fun get(id: Int): ScheduleDto? {
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
    override fun delete(id: Int): Boolean {
        return db.delete(id)
    }
}