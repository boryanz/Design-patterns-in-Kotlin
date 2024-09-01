package decorator

fun Car.decorate(block: () -> Unit): Car {
    return object : Car {
        override fun drive() {
            block()
            this@decorate.drive()
        }
    }
}