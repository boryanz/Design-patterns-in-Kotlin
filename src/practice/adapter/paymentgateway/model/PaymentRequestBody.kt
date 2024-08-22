package practice.adapter.paymentgateway.model

data class PaymentRequestBody(
    val from: String,
    val to: String,
    val amount: Int,
    val country: String
)
