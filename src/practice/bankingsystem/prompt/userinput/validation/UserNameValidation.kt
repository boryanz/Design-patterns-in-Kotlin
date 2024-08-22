package practice.bankingsystem.prompt.userinput.validation

import practice.bankingsystem.dataholder.authentication.AuthenticationState
import practice.bankingsystem.dataholder.db.BankDb
import practice.bankingsystem.prompt.userinput.UserInputValidationStrategy

class UserNameValidation : UserInputValidationStrategy {

    private val database = BankDb
    private val authState = AuthenticationState

    override fun isValidUserInput(userInput: String): Boolean {
        return userInput.isNotEmpty() && authState.getLoggedInUser()?.username != userInput
    }

    fun isUserNameMatchingFromDb(userName: String): Boolean {
        return database.users.any { it.username == userName }
    }
}