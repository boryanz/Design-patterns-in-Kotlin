package practice.bankingsystem.usecase.createuser

import practice.bankingsystem.model.AccountInfo
import practice.bankingsystem.utils.lineBreak
import practice.bankingsystem.utils.requireUserInput

class CreateBankAccountUseCase {
    fun create(): AccountInfo {
        print("Initial amount: ")
        val amount = requireUserInput()
        return runCatching {
            AccountInfo(
                amount = amount.toInt(),
                iban = "IBAN"
            )
        }.onFailure {
            lineBreak(1)
            println("You entered wrong amount. Try again")
            create()
        }.getOrThrow()
    }
}