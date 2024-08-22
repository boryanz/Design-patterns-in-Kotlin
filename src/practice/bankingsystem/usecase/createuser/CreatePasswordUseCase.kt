package practice.bankingsystem.usecase.createuser

import practice.bankingsystem.prompt.userinput.UserInputValidationStrategy
import practice.bankingsystem.utils.requireUserInput

class CreatePasswordUseCase(private val userInputValidationStrategy: UserInputValidationStrategy) {
    fun create(): String {
        print("Your password: ")
        val pass = requireUserInput()
        return if (!userInputValidationStrategy.isValidUserInput(pass)) {
            println("Password doesn't match the requirements.")
            create()
        } else {
            return pass
        }
    }
}