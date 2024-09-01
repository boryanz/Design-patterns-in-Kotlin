package observer

fun main() {
    val weatherStation = WeatherStation()
    CurrentConditionsDisplay(weatherStation)
    weatherStation.setData(12, 34, 1032)
    WeatherStatisticsDisplay(weatherStation)
    weatherStation.setData(22, 12, 1019)
}

