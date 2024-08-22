package practice.bankingsystem.prompt.transfer

import practice.bankingsystem.dataholder.authentication.AuthenticationState
import practice.bankingsystem.navigation.controller.Controller
import practice.bankingsystem.prompt.dashboard.NavOption
import practice.bankingsystem.model.BankUser
import practice.bankingsystem.observers.TransferObserver
import practice.bankingsystem.usecase.transfer.*
import practice.bankingsystem.utils.fakeLoadingState
import practice.bankingsystem.utils.lineBreak
import practice.bankingsystem.utils.printSection
import practice.bankingsystem.utils.requireUserInput

class MoneyTransfer : TransferObserver {

    private val getAvailableAccountsForTransferUseCase = GetAvailableAccountsForTransferUseCase()
    private val moneyTransferUseCase = MoneyTransferUseCase()

    private var recipient: String? = null

    override fun onMoneySent() {
        Controller.navigate(NavOption.dashboard)
    }

    fun init() {
        printSection {
            val availableAccounts = getAvailableAccountsForTransferUseCase()
            if (availableAccounts.isEmpty()) {
                lineBreak(1)
                println("There is no available accounts to send money!")
                Controller.navigate(NavOption.dashboard)
                return@printSection
            }

            println("Available account to transfer money: ")
            printAvailableUsers(availableAccounts)
            print("Account name would you like to transfer money: ")
            val receiverUserName = requireUserInput()
            recipient = receiverUserName
            transferMoney(receiverUserName)
        }
    }

    private fun printAvailableUsers(users: List<BankUser>) {
        users.forEachIndexed { index, bankUser ->
            val correctIndex = index + 1
            println("$correctIndex. ${bankUser.username}")
        }
    }

    private fun transferMoney(receiverUserName: String) {
        printSection {
            println("How much money would you like to transfer?")
            print("Amount: ")
            val amount = requireUserInput()
            val response = moneyTransferUseCase(
                sender = AuthenticationState.getLoggedInUser()?.username.orEmpty(),
                receiver = receiverUserName,
                amount = amount
            )
            when (response) {
                is TransferState.Success -> printConfirmation(response.receipt)
                is TransferState.Error -> {
                    when (response.cause) {
                        ErrorType.missing_data -> printMissingDataError()
                        ErrorType.available_amount_exceeded -> printAvailableAmountExceededError()
                        ErrorType.amount_not_correct -> printAmountNotCorrectError()
                    }
                }
            }
        }
    }

    private fun printConfirmation(receipt: Receipt) {
        printSection {
            fakeLoadingState()
            lineBreak(1)
            println("You have successfully sent money to ${receipt.recipient}")
            lineBreak(1)
            println("Transfer confirmation:")
            println("Transfer date: ${receipt.transferDate}")
            println("Sender: ${receipt.sender}")
            println("Recipient: ${receipt.recipient}")
            println("Amount sent: ${receipt.sentAmount}")
            println("Available amount left: ${receipt.availableAmount}")
            lineBreak(1)
            println("Press any key to continue.")
            requireUserInput()
            Controller.navigate(NavOption.dashboard)
        }
    }

    private fun printMissingDataError() {
        lineBreak(1)
        println("Error occurred. Invalid data!")
        retry()
    }

    private fun printAvailableAmountExceededError() {
        lineBreak(1)
        println("You don't have enough buying power! Try again.")
        retry()
    }

    private fun printAmountNotCorrectError() {
        lineBreak(1)
        println("You have placed invalid amount! Try again.")
        retry()
    }

    private fun retry() {
        recipient?.let { transferMoney(it) }.also { recipient = null }
    }
}