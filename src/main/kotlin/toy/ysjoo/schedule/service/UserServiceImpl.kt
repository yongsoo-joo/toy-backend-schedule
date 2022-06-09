package toy.ysjoo.schedule.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import toy.ysjoo.schedule.dto.UserDto
import toy.ysjoo.schedule.repository.UserRepository

@Service
class UserServiceImpl(
    private val repository: UserRepository
) : RestService<UserDto> {
    /**
     *
     */
    @Transactional
    override fun add(e: UserDto): Long {
        val res = repository.save(e.toUser())
        return res.id
    }

    /**
     *
     */
    @Transactional
    override fun update(e: UserDto): Boolean {
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
    override fun get(id: Long): UserDto? {
        val res = repository.findByIdOrNull(id)
        return when (res != null) {
            true -> res.toUserDto()
            false -> null
        }
    }

    @Transactional(readOnly = true)
    override fun getAll(): List<UserDto> {
        val userDtoList = mutableListOf<UserDto>()
        val res = repository.findAll()
        res.forEach {
            userDtoList.add(it.toUserDto())
        }
        return userDtoList
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