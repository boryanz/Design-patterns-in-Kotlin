package practice.bankingsystem.prompt.welcome

import practice.bankingsystem.utils.lineBreak

enum class StartupOption {
    createUser, exit, unknown
}

class WelcomePrompt {

    fun welcomeMessage() {
        lineBreak(2)
        println("Hi, welcome to the Secure Bank of Macedonia.")
        println("----------------------------------------------")
        lineBreak(2)
    }

    fun userEntry(): StartupOption {
        println("Choose your options: ")
        println("1. Create user")
        println("2. Exit")
        lineBreak(1)
        print("Option: ")
        val userOption = readlnOrNull()
        return when (userOption) {
            "1" -> StartupOption.createUser
            "2" -> StartupOption.exit
            else -> {
                println("Unknown option choosed. Try agian")
                StartupOption.unknown
            }
        }
    }
}