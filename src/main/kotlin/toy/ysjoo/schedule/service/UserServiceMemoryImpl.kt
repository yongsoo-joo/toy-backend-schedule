package toy.ysjoo.schedule.service

import org.springframework.stereotype.Service
import toy.ysjoo.schedule.database.UserDatabaseImpl
import toy.ysjoo.schedule.dto.UserDto
import toy.ysjoo.schedule.mapper.UserMapper
import javax.transaction.Transactional

@Service
class UserServiceMemoryImpl(
    private val userMapper: UserMapper
) : RestService<UserDto> {
    private val db: UserDatabaseImpl = UserDatabaseImpl()

    /**
     *
     */
    override fun add(e: UserDto): Long {
        return db.add(userMapper.toDomain(e))
    }

    /**
     *
     */
    @Transactional
    override fun update(e: UserDto): Boolean {
        return db.update(userMapper.toDomain(e))
    }

    /**
     *
     */
    override fun get(id: Long): UserDto? {
        val user = db.search(id)
        return when (user != null) {
            true -> userMapper.toDto(user)
            false -> null
        }
    }

    override fun getAll(): List<UserDto> {
        val userDtoList = mutableListOf<UserDto>()
        db.searchAll().forEach {
            userDtoList.add(userMapper.toDto(it))
        }
        return userDtoList
    }

    /**
     *
     */
    override fun delete(id: Long): Boolean {
        return db.delete(id)
    }
}