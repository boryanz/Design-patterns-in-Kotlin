package practice.bankingsystem.prompt.userinput.validation

import practice.bankingsystem.dataholder.db.BankDb
import practice.bankingsystem.prompt.userinput.UserInputValidationStrategy

class PasswordValidation : UserInputValidationStrategy {

    private val database = BankDb

    override fun isValidUserInput(userInput: String): Boolean {
        return userInput.isNotEmpty()
    }

    fun isPasswordMatchingFromDb(password: String): Boolean {
        return database.users.any { it.password == password }
    }
}