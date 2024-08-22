package adapter

interface NewBankAccount {
    fun showTransactions(): List<String>
    fun withdrawCash(): String
}