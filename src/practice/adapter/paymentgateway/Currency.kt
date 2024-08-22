package practice.adapter.paymentgateway

sealed interface Currency {
    val code: String
    data class MacedonianDenar(override val code: String) : Currency
    data class AlbanianLeki(override val code: String): Currency
    data class BosnianMarka(override val code: String): Currency
}