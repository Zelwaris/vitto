import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import java.io.File

fun main(args: Array<String>) = Vitto().main(args)

fun String.runCommand(path: File) {
    ProcessBuilder(*split(" ").toTypedArray())
        .directory(path)
        .inheritIO()
        .start()
        .waitFor()
}

fun String.runCommand() {
    ProcessBuilder(*split(" ").toTypedArray())
        .inheritIO()
        .start()
        .waitFor()
}
