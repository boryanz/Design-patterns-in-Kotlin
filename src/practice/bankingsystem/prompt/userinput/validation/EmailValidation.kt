package practice.bankingsystem.prompt.userinput.validation

import practice.bankingsystem.prompt.userinput.UserInputValidationStrategy

class EmailValidation : UserInputValidationStrategy {
    override fun isValidUserInput(userInput: String): Boolean {
        return userInput.isNotEmpty()
    }
}