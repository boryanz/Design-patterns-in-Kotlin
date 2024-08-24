package proxy

interface Book {
    fun getTitle(): String
}

class RealBook(): Book {
    override fun getTitle(): String {
        return "Harry Potter and Prisoner of Azkaban"
    }
}

class CachedBookProxy(): Book {
    private var cachedTitle: String? = null
    override fun getTitle(): String {
        if (cachedTitle == null) {
            
        }
    }

}