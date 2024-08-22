package practice.bankingsystem.utils

fun lineBreak(linesNum: Int) {
    repeat(linesNum) { println() }
}

fun pressAnyKeyToContinue() {
    lineBreak(1)
    println("Press any key to continue.")
    readlnOrNull()
}

fun fakeLoadingState() {
    print("Loading")
    for (i in 1..3) {
        print(".")
        Thread.sleep(1000)
    }
    println()
}

fun printSection(block: () -> Unit) {
    println("------------------------------------------------------------------------")
    lineBreak(1)
    block()
    lineBreak(1)
    println("-----------------------------------------------------------------------")
}