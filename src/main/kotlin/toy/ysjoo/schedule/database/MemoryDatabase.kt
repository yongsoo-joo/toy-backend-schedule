package toy.ysjoo.schedule.database

interface MemoryDatabase<T> {
    fun add(id: Long, data: T): Boolean
    fun add(data: T, isAutoIndex: Boolean = true): Long
    fun delete(id: Long): Boolean
    fun update(id: Long, data: T): Boolean
    fun update(data: T): Boolean
    fun search(id: Long): T?
    fun search(data: T): Long?
    fun searchAll(): List<T>
}
