package practice.bankingsystem.observers

interface AuthenticationObserver : Observer {
    fun onUserAuthenticated()
    fun onUserNotAuthenticated()
}