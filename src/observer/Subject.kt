package observer

/**
 * Contract for class which will serve as Publisher in this case [WeatherStation] class
 */
interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}




