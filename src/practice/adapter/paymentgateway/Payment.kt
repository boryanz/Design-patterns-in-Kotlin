package practice.adapter.paymentgateway

import practice.adapter.paymentgateway.model.PaymentRequestBody
import practice.adapter.paymentgateway.model.Receipt

interface Payment {
    fun processPayment(paymentRequestBody: PaymentRequestBody): Receipt?
}