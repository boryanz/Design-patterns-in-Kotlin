package practice.adapter.paymentgateway.model

data class Receipt(
    val from: String,
    val to: String,
    val date: String,
    val transferredAmount: Int,
    val remainingAmount: Int,
    val summary: String,
)
