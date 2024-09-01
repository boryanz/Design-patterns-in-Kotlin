package observer

/**
 * Contract for all classes which needs to be updated from the Subject
 */
interface Observer {
    fun notify(temperature: Int, humidity: Int, pressure: Int)
}
