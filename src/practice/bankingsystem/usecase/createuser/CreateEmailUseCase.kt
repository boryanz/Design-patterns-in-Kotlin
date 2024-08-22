package practice.bankingsystem.usecase.createuser

import practice.bankingsystem.prompt.userinput.UserInputValidationStrategy
import practice.bankingsystem.utils.requireUserInput

class CreateEmailUseCase(private val userInputValidationStrategy: UserInputValidationStrategy) {
    fun create(): String {
        print("Your email: ")
        val email = requireUserInput()
        return if (!userInputValidationStrategy.isValidUserInput(email)) {
            println("Email doesn't match the requirements.")
            create()
        } else {
            return email
        }
    }
}