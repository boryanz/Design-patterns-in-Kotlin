package practice.bankingsystem.prompt.createuser

import practice.bankingsystem.navigation.controller.Controller
import practice.bankingsystem.usecase.createuser.CreateBankAccountUseCase
import practice.bankingsystem.usecase.createuser.CreateEmailUseCase
import practice.bankingsystem.usecase.createuser.CreatePasswordUseCase
import practice.bankingsystem.usecase.createuser.CreateUserNameUseCase
import practice.bankingsystem.prompt.dashboard.NavOption
import practice.bankingsystem.dataholder.db.BankDb
import practice.bankingsystem.model.AccountInfo
import practice.bankingsystem.model.BankUser
import practice.bankingsystem.observers.CreateUserObserver
import practice.bankingsystem.prompt.userinput.validation.EmailValidation
import practice.bankingsystem.prompt.userinput.validation.PasswordValidation
import practice.bankingsystem.prompt.userinput.validation.UserNameValidation
import practice.bankingsystem.utils.fakeLoadingState
import practice.bankingsystem.utils.printSection

class UserCreator : CreateUserObserver {

    init {
        BankDb.registerObserver(this@UserCreator)
    }

    private val createUserNameUseCase = CreateUserNameUseCase(userInputValidationStrategy = UserNameValidation())
    private val createEmailUseCase = CreateEmailUseCase(userInputValidationStrategy = EmailValidation())
    private val createPasswordUseCase = CreatePasswordUseCase(userInputValidationStrategy = PasswordValidation())
    private val createBankAccountUseCase = CreateBankAccountUseCase()

    override fun onNewUserCreated(isFirstRegistration: Boolean) {
        printSection {
            fakeLoadingState()
            println("User added successfully.")
            if (isFirstRegistration) {
                Controller.navigate(NavOption.login)
            } else {
                Controller.navigate(NavOption.dashboard)
            }
        }
    }

    fun init() {
        val bankUser = BankUser(
            username = createUserName(),
            password = createPassword(),
            email = createEmail(),
            bankAccountInfo = createBankAccountInfo()
        )
        BankDb.saveUser(bankUser)
    }

    private fun createUserName(): String = createUserNameUseCase.create()

    private fun createPassword(): String = createPasswordUseCase.create()

    private fun createEmail(): String = createEmailUseCase.create()

    private fun createBankAccountInfo(): AccountInfo = createBankAccountUseCase.create()

}