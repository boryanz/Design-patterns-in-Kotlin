package observer

class WeatherStatisticsDisplay(weatherStation: WeatherStation) : Observer {

    init {
        weatherStation.registerObserver(this)
    }

    override fun notify(temperature: Int, humidity: Int, pressure: Int) {
        println("Some weather statistics using temp:$temperature, humid:$humidity, and pressure:$pressure")
    }
}