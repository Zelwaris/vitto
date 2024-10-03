import utils.colors.RESET

fun main(args: Array<String>) = Vitto().main(args)

fun String.runCommand() {
    ProcessBuilder(*split(" ").toTypedArray())
        .inheritIO()
        .start()
        .waitFor()
}

fun printlnClr(message: String, startColor: String = "") {
    println("${startColor}${message}$RESET")
}
