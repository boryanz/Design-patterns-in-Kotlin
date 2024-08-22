package factory.implementation

class WeatherFactoryImpl : WeatherFactory {
    override fun getWeatherModel(model: String): WeatherReport {
        return when (model) {
            "gfs" -> WeatherReport.GFSModel(1011, rainProbability = 80)
            "irf" -> WeatherReport.IRFModel("strong", thermalCapacity = 95, pressure = 1018, rainProbability = 20)
            "wrf" -> WeatherReport.WRFModel(1019, 20, thermalCapacity = 30)
            else -> throw IllegalStateException("Unknown weather forecast model")
        }
    }
}