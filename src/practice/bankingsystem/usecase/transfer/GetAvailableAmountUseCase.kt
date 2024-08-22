package practice.bankingsystem.usecase.transfer

import practice.bankingsystem.dataholder.authentication.AuthenticationState

class GetAvailableAmountUseCase {
    operator fun invoke(): Int {
        val user = AuthenticationState.getLoggedInUser() ?: throw IllegalStateException("Login to get the data!")
        return user.bankAccountInfo.amount
    }
}