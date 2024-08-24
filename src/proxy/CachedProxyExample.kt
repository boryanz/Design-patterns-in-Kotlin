package proxy

import practice.bankingsystem.utils.requireUserInput

interface Book {
    fun getTitle(): String
}

class RealBook() : Book {
    override fun getTitle(): String {
        return "Harry Potter and Prisoner of Azkaban"
    }
}

/**
 * This is example of cached proxy implementation. Proxy pattern provides abstraction level between
 * the object and the client. Usually it restricts the object access or
 * apply more functionality like caching, encryption etc....
 */
class CachedBookProxy(private val book: RealBook) : Book {
    private var cachedTitle: String? = null
    override fun getTitle(): String {
        if (cachedTitle == null) {
            println("Title now cached!")
            return book.getTitle().also { cachedTitle = it }
        } else {
            println("Title returned from a local cache.")
            return cachedTitle.orEmpty()
        }
    }
}

fun main() {
    val book = RealBook()
    val proxy = CachedBookProxy(book)
    println(proxy.getTitle())
    requireUserInput()
    println(proxy.getTitle())
}