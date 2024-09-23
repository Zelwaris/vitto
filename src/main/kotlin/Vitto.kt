import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option

class Vitto : CliktCommand() {
    val resolution by option("-r", "--resolution", help="The resolution to convert to. Usage: 1920x1080")
    val input by argument()

    override fun run() {
        echo("Hello Shashumga!")
    }
}