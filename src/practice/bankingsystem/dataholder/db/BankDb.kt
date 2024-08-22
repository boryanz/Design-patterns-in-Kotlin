package practice.bankingsystem.dataholder.db

import practice.bankingsystem.observers.Publisher
import practice.bankingsystem.model.BankUser
import practice.bankingsystem.observers.CreateUserObserver
import practice.bankingsystem.observers.Observer

object BankDb : Publisher {

    var users: MutableList<BankUser> = mutableListOf()
        private set

    override val observers: MutableList<Observer> = mutableListOf()

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun saveUser(bankUser: BankUser) {
        users.add(bankUser)
        val hasOnlyOneUser = users.size == 1
        observers notifyObserversWhether hasOnlyOneUser
    }

    private infix fun List<Observer>.notifyObserversWhether(hasOneUser: Boolean) {
        filterIsInstance<CreateUserObserver>().firstOrNull()?.onNewUserCreated(hasOneUser)
    }

}