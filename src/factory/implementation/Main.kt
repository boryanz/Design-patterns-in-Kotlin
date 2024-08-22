package factory.implementation

fun main() {
    val forecastModel = "gfs"
    val weatherFactory: WeatherFactory = WeatherFactoryImpl()
    val forecast = weatherFactory.getWeatherModel(forecastModel)
    forecast.reportWeather()
}