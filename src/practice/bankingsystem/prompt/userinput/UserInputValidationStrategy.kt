package practice.bankingsystem.prompt.userinput

interface UserInputValidationStrategy {
    fun isValidUserInput(userInput: String): Boolean
}