package toy.ysjoo.schedule.service

import org.springframework.stereotype.Service
import toy.ysjoo.schedule.database.UserDatabaseImpl
import toy.ysjoo.schedule.dto.UserDto
import javax.transaction.Transactional

@Service
class UserServiceMemoryImpl(
    private val db: UserDatabaseImpl = UserDatabaseImpl()
) : RestService<UserDto> {
    /**
     *
     */
    override fun add(e: UserDto): Long {
        return db.add(e.toUser())
    }

    /**
     *
     */
    @Transactional
    override fun update(e: UserDto): Boolean {
        return db.update(e.toUser())
    }

    /**
     *
     */
    override fun get(id: Long): UserDto? {
        val user = db.search(id)
        return when (user != null) {
            true -> user.toUserDto()
            false -> null
        }
    }

    override fun getAll(): List<UserDto> {
        val userDtoList = mutableListOf<UserDto>()
        db.searchAll().forEach {
            userDtoList.add(it.toUserDto())
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