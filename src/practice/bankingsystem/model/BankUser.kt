package practice.bankingsystem.model

data class BankUser(
    val username: String,
    val password: String,
    val email: String,
    val bankAccountInfo: AccountInfo,
)

data class AccountInfo(
    val amount: Int,
    val iban: String
)