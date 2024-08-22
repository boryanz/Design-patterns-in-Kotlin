package practice.adapter.paymentgateway

import practice.adapter.paymentgateway.model.PaymentRequestBody
import practice.adapter.paymentgateway.model.Receipt

class PaymentAdapter(private val legacyPaymentGateWay: LegacyPaymentGateWay) : Payment {

    override fun processPayment(paymentRequestBody: PaymentRequestBody): Receipt? {
        val hasPassed = legacyPaymentGateWay.makePayment(paymentRequestBody.amount, "MKD")
        if (!hasPassed) return null

        val currency = getCurrency(paymentRequestBody.country)
        val remainingAmount = getTotalAmount() - paymentRequestBody.amount
        return Receipt(
            from = paymentRequestBody.from,
            to = paymentRequestBody.to,
            date = java.util.Date().toString(),
            transferredAmount = paymentRequestBody.amount,
            remainingAmount = remainingAmount,
            summary = "You have sent money from ${paymentRequestBody.from} to ${paymentRequestBody.to}" +
                    " with amount of ${paymentRequestBody.amount} ${currency.code}." +
                    "You have $remainingAmount ${currency.code} available!"
        )
    }

    private fun getTotalAmount(): Int {
        return 100000
    }

    private fun getCurrency(country: String): Currency {
        return when (country) {
            "Albania" -> Currency.AlbanianLeki("LEK")
            "Macedonia" -> Currency.MacedonianDenar("MKD")
            "Bosnia and Herzegovina" -> Currency.BosnianMarka("KM")
            else -> throw IllegalStateException("Unknown country")
        }
    }
}