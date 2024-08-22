package practice.bankingsystem.observers

interface Publisher {

     val observers: MutableList<Observer>

     fun registerObserver(observer: Observer)

     fun removeObserver(observer: Observer)
}