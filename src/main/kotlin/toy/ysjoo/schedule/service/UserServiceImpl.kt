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
        if (user != null) {
            return user.toUserDto()
        }
        return null
    }

    /**
     *
     */
    override fun delete(id: Int): Boolean {
        return db.delete(id)
    }
}