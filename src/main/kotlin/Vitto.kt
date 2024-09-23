import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option

class Vitto : CliktCommand() {
    private val resolution by option("-r", "--resolution", help="The resolution to convert to. Uses width and scales according to the aspect ratio.")
    private val input by argument()

    override fun run() {
        FFmpeg.execute(input, resolution)
    }
}