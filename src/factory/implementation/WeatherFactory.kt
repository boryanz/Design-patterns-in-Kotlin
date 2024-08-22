package factory.implementation

interface WeatherFactory {
    fun getWeatherModel(model: String): WeatherReport
}