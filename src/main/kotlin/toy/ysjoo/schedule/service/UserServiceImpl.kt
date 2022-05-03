package toy.ysjoo.schedule.service

import toy.ysjoo.schedule.database.UserDatabaseImpl
import toy.ysjoo.schedule.dto.UserDto

class UserServiceImpl(
    private val db: UserDatabaseImpl = UserDatabaseImpl()
) : RestService<UserDto> {
    /**
     *
     */
    override fun add(e: UserDto): Int {
        return db.add(e.toUser())
    }

    /**
     *
     */
    override fun update(e: UserDto): Boolean {
        return db.update(e.toUser())
    }

    /**
     *
     */
    override fun get(id: Int): UserDto? {
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
    override fun delete(id: Int): Boolean {
        return db.delete(id)
    }
}