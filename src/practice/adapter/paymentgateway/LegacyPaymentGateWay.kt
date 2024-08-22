package practice.adapter.paymentgateway

class LegacyPaymentGateWay {
    fun makePayment(amount: Int, currencyCode: String): Boolean {
        return  (amount > 0 && currencyCode.isNotBlank())
    }
}