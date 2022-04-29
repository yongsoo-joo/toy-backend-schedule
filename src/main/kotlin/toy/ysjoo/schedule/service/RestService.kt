package toy.ysjoo.schedule.service

interface RestService<T> {
    fun add(e: T): Int
    fun update(e: T): Boolean
    fun get(id: Int): T?
    fun delete(id: Int): Boolean
}