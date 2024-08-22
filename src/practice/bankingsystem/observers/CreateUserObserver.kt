package practice.bankingsystem.observers

interface CreateUserObserver : Observer {
    fun onNewUserCreated(isFirstRegistration: Boolean)
}