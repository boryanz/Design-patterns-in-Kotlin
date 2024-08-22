package factory.implementation

sealed interface WeatherReport {

    fun reportWeather()

    data class GFSModel(
        val pressure: Int,
        val rainProbability: Int
    ) : WeatherReport {
        override fun reportWeather() {
            if (pressure < 1017 && rainProbability > 60) {
                println("It's a unstable day, bring your umbrella.")
            }
        }
    }

    data class WRFModel(
        val pressure: Int,
        val rainProbability: Int,
        val thermalCapacity: Int,
    ) : WeatherReport {
        override fun reportWeather() {
            when {
                pressure > 1017 && rainProbability > 60 -> {
                    println("It's a unstable day, bring your umbrella.")
                }
                thermalCapacity > 90 -> println("Good day for soaring")
            }
        }
    }

    data class IRFModel(
        val wind: String,
        val thermalCapacity: Int,
        val pressure: Int,
        val rainProbability: Int
    ) : WeatherReport {
        override fun reportWeather() {
            when {
                pressure > 1017 && rainProbability > 60 -> {
                    println("It's a unstable day, bring your umbrella.")
                }
                thermalCapacity > 90 -> println("Good day for soaring")
            }
        }
    }
}