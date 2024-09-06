import practice.bankingsystem.utils.requireUserInput

interface VendingMachineState {
    fun processRequest()
}

class IdleState : VendingMachineState {
    override fun processRequest() {
        println("Machine ready. Please select item and insert coins.")
        print("Coins amount: ")
        requireUserInput()
    }
}

class InsertMoneyState : VendingMachineState {
    override fun processRequest() {
        println("Inserted coins. Please wait until your item is processed.")
        Thread.sleep(2000)
    }

}

class ItemProcessingState : VendingMachineState {
    override fun processRequest() {
        println("Your item has been processed. The dispensing starts in the moment.")
        Thread.sleep(2000)
    }
}

class DispenseItemState : VendingMachineState {
    override fun processRequest() {
        println("Your item has been processed. Please take the cover out and pick the item.")
        Thread.sleep(2000)
    }
}

object VendingMachineStateHolder {
    private var state: VendingMachineState? = null

    fun setNewState() {
        when (state) {
            null -> state = IdleState()
            is IdleState -> state = InsertMoneyState()
            is InsertMoneyState -> state = ItemProcessingState()
            is ItemProcessingState -> state = DispenseItemState()
        }
    }

    fun handleRequest() {
        state?.processRequest()
    }
}

class VendingMachine {

    fun init() {
        println("Welcome to vending machine state pattern!")
        println("Press any key to continue...")
        requireUserInput()
        VendingMachineStateHolder.setNewState()
        VendingMachineStateHolder.handleRequest()
        VendingMachineStateHolder.setNewState()
        VendingMachineStateHolder.handleRequest()
        VendingMachineStateHolder.setNewState()
        VendingMachineStateHolder.handleRequest()
        VendingMachineStateHolder.setNewState()
        VendingMachineStateHolder.handleRequest()
    }
}

fun main() {
    val vendingMachine = VendingMachine()
    vendingMachine.init()
}