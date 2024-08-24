package adapter

class BankAccount {
    fun showTransactions(): List<String> {
        return listOf("Transaction1", "Transaction2", "Transaction3", "Transaction4")
    }

    fun withDrawCash(): Int {
        return 10000
    }
}