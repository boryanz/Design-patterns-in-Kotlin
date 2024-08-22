package practice.bankingsystem.dataholder.authentication

import practice.bankingsystem.observers.Publisher
import practice.bankingsystem.dataholder.db.BankDb
import practice.bankingsystem.model.BankUser
import practice.bankingsystem.observers.AuthenticationObserver
import practice.bankingsystem.observers.Observer


object AuthenticationState : Publisher {

    private val users = BankDb.users
    private var loggedInUser: BankUser? = null

    override val observers: MutableList<Observer> = mutableListOf()

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun authenticated(username: String, password: String) {
        loggedInUser = users.firstOrNull {
            it.username == username && it.password == password
        }
        observers.notifyAuthenticated()
    }

    fun logout() {
        observers.notifyNotAuthenticated()
    }

    fun getLoggedInUser() = loggedInUser

    private fun List<Observer>.notifyAuthenticated() {
        filterIsInstance<AuthenticationObserver>().forEach { it.onUserAuthenticated() }
    }

    private fun List<Observer>.notifyNotAuthenticated() {
        filterIsInstance<AuthenticationObserver>().forEach { it.onUserNotAuthenticated() }
    }

}