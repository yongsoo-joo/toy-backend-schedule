package toy.ysjoo.schedule.service

interface RestService<T> {
    fun add(e: T): Long
    fun update(e: T): Boolean
    fun get(id: Long): T?
    fun getAll(): List<T>
    fun delete(id: Long): Boolean
}