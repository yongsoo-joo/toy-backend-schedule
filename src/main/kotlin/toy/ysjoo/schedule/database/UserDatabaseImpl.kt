package toy.ysjoo.schedule.database

import toy.ysjoo.schedule.domain.User

class UserDatabaseImpl(
    private var index: Int = 0,
    private val userList: MutableList<User> = mutableListOf(User())
) : MemoryDatabase<User> {

    /**
     *®®
     */
    override fun add(data: User): Int {
        data.id = ++index
        userList.add(index, data)
        println(userList)
        return index
    }

    /**
     *
     */
    override fun delete(index: Int): Boolean {
        val user = search(index) ?: return false
        if (userList.remove(user))
            return true
        return false
    }

    /**
     *
     */
    override fun update(index: Int, data: User): Boolean {
        val user = search(index)
        when (user != null) {
            true -> userList[index] = data
            false -> add(data)
        }
        return true
    }

    /**
     *
     */
    override fun update(data: User): Boolean {
        val index = search(data) ?: 0
        if (index > 0)
            return update(index, data)
        return false
    }

    /**
     *
     */
    override fun search(index: Int): User? {
        for (user in userList) {
            if (user.id == index)
                return user
        }
        return null
    }

    /**
     *
     */
    override fun search(data: User): Int? {
        for (user in userList) {
            if (user == data)
                return user.id
        }
        return null
    }
}