package practice.bankingsystem.navigation.controller

import practice.bankingsystem.prompt.authentication.Authentication
import practice.bankingsystem.prompt.createuser.UserCreator
import practice.bankingsystem.prompt.dashboard.Dashboard
import practice.bankingsystem.prompt.dashboard.NavOption
import practice.bankingsystem.prompt.transfer.MoneyTransfer
import kotlin.system.exitProcess

object Controller {

    private val createUser = UserCreator()
    private val moneyTransfer = MoneyTransfer()
    private val dashboard = Dashboard()
    private val authentication = Authentication()

    fun navigate(navOption: NavOption) {
        when (navOption) {
            NavOption.dashboard -> dashboard.init()
            NavOption.login -> authentication.login()
            NavOption.create_new_account -> createUser.init()
            NavOption.transfer_money -> moneyTransfer.init()
            NavOption.logout -> authentication.logout()
            NavOption.delete_account -> {
                println("Account has been deleted.")
                exitProcess(0)
            }
        }
    }
}