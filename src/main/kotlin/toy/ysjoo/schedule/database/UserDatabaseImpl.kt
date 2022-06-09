package toy.ysjoo.schedule.database

import toy.ysjoo.schedule.domain.User

class UserDatabaseImpl(
    private var index: Long = 0,
    private val userList: MutableList<User> = mutableListOf()
) : MemoryDatabase<User> {

    /**
     *
     */
    override fun add(id: Long, data: User): Boolean {
        data.id = id
        return add(data, false) > 0
    }

    /**
     *
     */
    override fun add(data: User, isAutoIndex: Boolean): Long {
        val idx = when (isAutoIndex) {
            true -> {
                while (search(++index) != null) Unit
                index
            }
            false -> {
                if (search(data.id) == null) data.id
                else 0
            }
        }
        if (idx > 0) {
            data.id = idx
            userList.add(data)
            println("[add] success to update userList : $userList")
        }
        return idx
    }

    /**
     *
     */
    override fun delete(id: Long): Boolean {
        return when (userList.removeIf { user -> (user.id == id) }) {
            true -> {
                println("[delete] updated userList : $userList")
                true
            }
            false -> {
                println("[delete] don't exist id in userList = $id")
                false
            }
        }
    }

    /**
     *
     */
    override fun update(id: Long, data: User): Boolean {
        var isUpdate = false

        userList.forEachIndexed { idx, user ->
            if (!isUpdate && user.id == id) {
                userList[idx] = data
                isUpdate = true
                println("[update] updated userList : $userList")
            }
        }

        if (!isUpdate) {
            isUpdate = add(id, data)
        }

        return isUpdate
    }

    /**
     *
     */
    override fun update(data: User): Boolean {
        return update(data.id, data)
    }

    /**
     *
     */
    override fun search(id: Long): User? {
        userList.forEach { user ->
            if (user.id == id)
                return user
        }
        return null
    }

    override fun searchAll(): List<User> {
        return userList
    }

    /**
     *
     */
    override fun search(data: User): Long? {
        userList.forEach { user ->
            if (data == user)
                return user.id
        }
        return null
    }
}