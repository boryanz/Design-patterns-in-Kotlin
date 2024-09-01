package observer

class CurrentConditionsDisplay(weatherStation: WeatherStation) : Observer {

    init {
        weatherStation.registerObserver(this)
    }

    override fun notify(temperature: Int, humidity: Int, pressure: Int) {
        println("Temperature: $temperature")
        println("Humidity: $humidity")
        println("Pressure: $pressure")
    }
}