package practice.bankingsystem

import practice.bankingsystem.prompt.createuser.UserCreator
import practice.bankingsystem.dataholder.db.BankDb
import practice.bankingsystem.observers.CreateUserObserver
import practice.bankingsystem.prompt.welcome.StartupOption
import practice.bankingsystem.prompt.welcome.WelcomePrompt
import kotlin.system.exitProcess

class Startup {

    private val createUser: UserCreator = UserCreator()

    fun start() {
        WelcomePrompt().apply {
            welcomeMessage()
            when (userEntry()) {
                StartupOption.createUser -> createUser.init()
                StartupOption.exit, StartupOption.unknown -> endProgram()
            }
        }
    }

    private fun endProgram(): Nothing = exitProcess(0)

}