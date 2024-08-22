package practice.bankingsystem.usecase.createuser

import practice.bankingsystem.prompt.userinput.UserInputValidationStrategy
import practice.bankingsystem.utils.requireUserInput

class CreateUserNameUseCase(private val userInputValidationStrategy: UserInputValidationStrategy) {
    fun create(): String {
        print("New username: ")
        val userName = requireUserInput()
        return if (!userInputValidationStrategy.isValidUserInput(userName)) {
            println("Username is taken.")
            create()
        } else {
            return userName
        }
    }
}