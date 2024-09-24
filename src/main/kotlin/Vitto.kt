
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.optional
import com.github.ajalt.clikt.parameters.options.option

class Vitto : CliktCommand() {
    private val path by argument().optional()

    private val resolution by option("-r", "--resolution", help = "The resolution to convert to. Uses width and scales according to the aspect ratio.")
    private val videoBitrate by option("-vb", "--videobitrate", help = "The video bitrate. Example: '96K' '9M'")
    private val audioBitrate by option("-ab", "--audiobitrate", help = "The audio bitrate. Example: '96K' '9M'")

    override fun run() {
        if (path.isNullOrEmpty()) {
            println("Error:$RESET No path specified!", RED)
            return
        }

        val ffResolution = FFmpegOption(resolution, FFmpegOptionType.RESOLUTION)
        val ffVideoBitrate = FFmpegOption(videoBitrate, FFmpegOptionType.VIDEO_BITRATE)
        val ffAudioBitrate = FFmpegOption(audioBitrate, FFmpegOptionType.AUDIO_BITRATE)

        val ffOptions = listOf(ffResolution, ffAudioBitrate, ffVideoBitrate)

        FFmpeg.execute(ffOptions, path!!)

        println("Done!", GREEN)
    }
}