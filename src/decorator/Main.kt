package decorator

import practice.bankingsystem.utils.lineBreak

fun main() {
    val car: Car = BasicCar()
    println("Without decoration")
    car.drive()
    lineBreak(1)
    println("With decoration")
    val newTurboCar = car.decorate { println("Added turbo mode!") }
    newTurboCar.drive()
}