package practice.bankingsystem.prompt.dashboard

import practice.bankingsystem.prompt.dashboard.NavOption.*
import practice.bankingsystem.dataholder.authentication.AuthenticationState
import practice.bankingsystem.navigation.controller.Controller
import practice.bankingsystem.utils.lineBreak
import practice.bankingsystem.utils.printSection
import practice.bankingsystem.utils.requireUserInput

enum class NavOption {
    login,
    dashboard,
    create_new_account,
    transfer_money,
    logout,
    delete_account
}

class Dashboard {

    private val userOptions = mutableMapOf(
        "1" to create_new_account,
        "2" to transfer_money,
        "3" to logout,
        "4" to delete_account
    )

    fun init() {
        printSection {
            val username = AuthenticationState.getLoggedInUser()?.username
            println("WELCOME, $username!")
            lineBreak(1)
            println("1. Create new account.")
            println("2. Send money.")
            println("3. Logout.")
            println("4. Delete account.")
            lineBreak(1)
            print("Option: ")
            val option = requireUserInput()
            val userOption = userOptions[option]
            if (userOption == null) {
                lineBreak(1)
                println("Invalid option chosen. Try again.")
                init()
                lineBreak(1)
            } else {
                Controller.navigate(userOption)
            }
        }
    }
}