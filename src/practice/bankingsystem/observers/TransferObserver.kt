package practice.bankingsystem.observers

interface TransferObserver : Observer {
    fun onMoneySent()
}