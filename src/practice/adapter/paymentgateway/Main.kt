package practice.adapter.paymentgateway

import practice.adapter.paymentgateway.model.PaymentRequestBody

fun main() {
    val paymentAdapter = PaymentAdapter(LegacyPaymentGateWay())
    val paymentRequestBody = PaymentRequestBody(
        from = "Boris Janevski",
        to = "Ivana Janevska",
        amount = 35000,
        country = "Macedonia"
    )
    val payment = paymentAdapter.processPayment(paymentRequestBody)
    println(payment?.summary ?: "Payment failed!!!")
}