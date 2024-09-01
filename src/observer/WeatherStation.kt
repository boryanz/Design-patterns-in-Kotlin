package observer


class WeatherStation : Subject {

    val observers = mutableListOf<Observer>()
    private var temperature = 0
    private var humidity = 0
    private var pressure = 0

    fun setData(temperature: Int, humidity: Int, pressure: Int) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.notify(temperature, humidity, pressure) }
    }

}