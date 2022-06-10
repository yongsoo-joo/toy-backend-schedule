package toy.ysjoo.schedule.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import toy.ysjoo.schedule.dto.UserDto
import toy.ysjoo.schedule.mapper.UserMapper
import toy.ysjoo.schedule.repository.UserRepository

@Service
@Transactional
class UserServiceImpl(
    private val repository: UserRepository,
    private val userMapper: UserMapper
) : RestService<UserDto> {
    /**
     *
     */
    override fun add(e: UserDto): Long {
        val res = repository.save(userMapper.toDomain(e))
        return res.id
    }

    /**
     *
     */
    override fun update(e: UserDto): Boolean {
        val res = repository.findByIdOrNull(e.id)
        return when (res != null) {
            true -> {
                userMapper.update(e, res)
                true
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
            true -> userMapper.toDto(res)
            false -> null
        }
    }

    @Transactional(readOnly = true)
    override fun getAll(): List<UserDto> {
        val userDtoList = mutableListOf<UserDto>()
        val res = repository.findAll()
        res.forEach {
            userDtoList.add(userMapper.toDto(it))
        }
        return userDtoList
    }

    /**
     *
     */
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