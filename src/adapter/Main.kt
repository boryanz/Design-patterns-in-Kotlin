package adapter

fun main() {
    val bankAdapter = BankAccountAdapter(BankAccount())
    bankAdapter.showTransactions().forEachIndexed { index, value ->
        println("$index. $value")
    }
    println(bankAdapter.withdrawCash())
}