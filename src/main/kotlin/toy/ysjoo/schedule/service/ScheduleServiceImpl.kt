package toy.ysjoo.schedule.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import toy.ysjoo.schedule.dto.ScheduleDto
import toy.ysjoo.schedule.repository.ScheduleRepository


@Service
class ScheduleServiceImpl(
    private val repository: ScheduleRepository
) : RestService<ScheduleDto> {

    /**
     *
     */
    @Transactional
    override fun add(e: ScheduleDto): Long {
        val res = repository.save(e.toSchedule())
        return res.id
    }

    /**
     *
     */
    @Transactional
    override fun update(e: ScheduleDto): Boolean {
        val res = repository.findByIdOrNull(e.id)
        return when (res != null) {
            true -> {
                res.update(e)
            }
            false -> false
        }
    }

    /**
     *
     */
    @Transactional(readOnly = true)
    override fun get(id: Long): ScheduleDto? {
        val res = repository.findByIdOrNull(id)
        return when (res != null) {
            true -> res.toScheduleDto()
            false -> null
        }
    }

    /**
     *
     */
    @Transactional(readOnly = true)
    override fun getAll(): List<ScheduleDto> {
        val scheduleDtoList = mutableListOf<ScheduleDto>()
        val res = repository.findAll()
        res.forEach {
            scheduleDtoList.add(it.toScheduleDto())
        }
        return scheduleDtoList
    }

    /**
     *
     */
    @Transactional
    override fun delete(id: Long): Boolean {
        val res = repository.findByIdOrNull(id)
        return when (res != null) {
            true -> {
                repository.delete(res)
                true
            }
            false -> false
        }
    }
}