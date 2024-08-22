package practice.bankingsystem.prompt.authentication

import practice.bankingsystem.dataholder.authentication.AuthenticationState
import practice.bankingsystem.navigation.controller.Controller
import practice.bankingsystem.prompt.dashboard.NavOption
import practice.bankingsystem.observers.AuthenticationObserver
import practice.bankingsystem.prompt.userinput.validation.PasswordValidation
import practice.bankingsystem.prompt.userinput.validation.UserNameValidation
import practice.bankingsystem.utils.fakeLoadingState
import practice.bankingsystem.utils.lineBreak
import practice.bankingsystem.utils.printSection
import practice.bankingsystem.utils.requireUserInput
import kotlin.system.exitProcess

class Authentication : AuthenticationObserver {

    private val userNameValidation = UserNameValidation()
    private val passwordValidation = PasswordValidation()
    private var passwordAttemptsLeft = 3

    init {
        AuthenticationState.registerObserver(this@Authentication)
    }

    override fun onUserAuthenticated() {
        Controller.navigate(NavOption.dashboard)
    }

    override fun onUserNotAuthenticated() {
        Controller.navigate(NavOption.login)
    }

    fun login() {
        printSection {
            println("LOGIN")
            val username = requestUserName()
            val password = requestPassword()
            fakeLoadingState()
            println("You have successfully logged in")
            AuthenticationState.authenticated(username, password)
        }
    }

    fun logout() {
        printSection {
            fakeLoadingState()
            println("You have been logged out successfully!")
            AuthenticationState.logout()
        }
    }

    private fun requestPassword(): String {
        print("Password: ")
        return requireUserInput().also {
            if (!passwordValidation.isPasswordMatchingFromDb(it)) {
                passwordAttemptsLeft--
                ensurePasswordAttemptsLeft()

                println("Invalid Password")
                requestPassword()
                lineBreak(1)
            }
        }
    }

    private fun requestUserName(): String {
        print("Username: ")
        return requireUserInput().also {
            if (!userNameValidation.isUserNameMatchingFromDb(it)) {
                println("Invalid username!")
                requestUserName()
                lineBreak(1)
            }
        }
    }

    private fun ensurePasswordAttemptsLeft() {
        if (passwordAttemptsLeft == 0) {
            println("Your account have been blocked!")
            exitProcess(0)
        }
    }
}