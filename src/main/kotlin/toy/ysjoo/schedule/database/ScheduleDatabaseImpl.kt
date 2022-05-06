package toy.ysjoo.schedule.database

import toy.ysjoo.schedule.domain.Schedule

class ScheduleDatabaseImpl(
    private var index: Int = 0,
    private val scheduleList: MutableList<Schedule> = mutableListOf()
) : MemoryDatabase<Schedule> {
    /**
     *
     */
    override fun add(id: Int, data: Schedule): Boolean {
        data.id = id
        return add(data, false) > 0
    }

    /**
     *
     */
    override fun add(data: Schedule, isAutoIndex: Boolean): Int {
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
            scheduleList.add(data)
            println("[add] success to update scheduleList : $scheduleList")
        }
        return idx
    }

    /**
     *
     */
    override fun delete(id: Int): Boolean {
        return when (scheduleList.removeIf { schedule -> (schedule.id == id) }) {
            true -> {
                println("[delete] update scheduleLsit : $scheduleList")
                true
            }
            false -> {
                println("[delete] don't exist id in scheduleList = $id")
                false
            }
        }
    }

    /**
     *
     */
    override fun update(data: Schedule): Boolean {
        return update(data.id, data)
    }

    /**
     *
     */
    override fun update(id: Int, data: Schedule): Boolean {
        var isUpdate = false

        scheduleList.forEachIndexed { idx, schedule ->
            if (!isUpdate && schedule.id == id) {
                scheduleList[idx] = data
                isUpdate = true
                println("[update] updated scheduleList : $scheduleList")
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
    override fun search(id: Int): Schedule? {
        scheduleList.forEach { schedule ->
            if (schedule.id == id)
                return schedule
        }
        return null
    }

    /**
     *
     */
    override fun searchAll(): List<Schedule> {
        return scheduleList
    }

    /**
     *
     */
    override fun search(data: Schedule): Int? {
        scheduleList.forEach { user ->
            if (data == user)
                return user.id
        }
        return null
    }
}