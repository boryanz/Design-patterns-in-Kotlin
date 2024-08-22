package adapter

class BankAccountAdapter(private val bankAccount: BankAccount) : NewBankAccount {
    override fun showTransactions(): List<String> {
        return bankAccount.showTransactions().take(3)
    }

    override fun withdrawCash(): String {
        return bankAccount.withDrawCash().toString()
    }
}