package practice.bankingsystem.usecase.transfer

import practice.bankingsystem.dataholder.authentication.AuthenticationState
import practice.bankingsystem.dataholder.db.BankDb
import practice.bankingsystem.model.BankUser

class GetAvailableAccountsForTransferUseCase {
    operator fun invoke(): List<BankUser> {
        val allUsers = BankDb.users
        val currentLoggedInUser = AuthenticationState.getLoggedInUser()
        return allUsers.filterNot { it.username == currentLoggedInUser?.username }
    }
}