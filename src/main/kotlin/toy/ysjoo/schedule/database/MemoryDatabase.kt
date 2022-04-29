package toy.ysjoo.schedule.database

interface MemoryDatabase<T> {
    fun add(data: T): Int
    fun delete(index: Int): Boolean
    fun update(index: Int, data: T): Boolean
    fun update(data: T): Boolean
    fun search(index: Int): T?
    fun search(data: T): Int?
}
