package practice.bankingsystem.usecase.transfer

import java.util.*


class MoneyTransferUseCase {

    private val getAvailableAmountUseCase = GetAvailableAmountUseCase()

    operator fun invoke(sender: String, receiver: String, amount: String): TransferState {
        if (sender.isEmpty() || receiver.isEmpty()) {
            return TransferState.Error(ErrorType.missing_data)
        }
        val amountToSend = runCatching { amount.toInt() }.onFailure {
            return TransferState.Error(ErrorType.amount_not_correct)
        }.getOrDefault(0)

        if (amountToSend > getAvailableAmountUseCase()) {
            return TransferState.Error(ErrorType.available_amount_exceeded)
        }

        val remainingAvailableAmount = (getAvailableAmountUseCase() - amountToSend).toString()
        return TransferState.Success(
            Receipt(
                transferDate = Date().toString(),
                sender = sender,
                recipient = receiver,
                availableAmount = remainingAvailableAmount,
                sentAmount = amount
            )
        )
    }
}

sealed interface TransferState {
    data class Error(val cause: ErrorType) : TransferState
    data class Success(val receipt: Receipt) : TransferState
}

enum class ErrorType {
    missing_data,
    available_amount_exceeded,
    amount_not_correct
}

data class Receipt(
    val transferDate: String,
    val sender: String,
    val recipient: String,
    val availableAmount: String,
    val sentAmount: String
)