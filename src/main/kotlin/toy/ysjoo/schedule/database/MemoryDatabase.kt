package toy.ysjoo.schedule.database

interface MemoryDatabase<T> {
    fun add(id: Int, data: T): Boolean
    fun add(data: T, isAutoIndex: Boolean = true): Int
    fun delete(id: Int): Boolean
    fun update(id: Int, data: T): Boolean
    fun update(data: T): Boolean
    fun search(id: Int): T?
    fun search(data: T): Int?
    fun searchAll(): List<T>
}
