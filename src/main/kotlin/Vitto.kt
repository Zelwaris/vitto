
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.optional
import com.github.ajalt.clikt.parameters.options.option
import ffmpeg.FFmpeg
import ffmpeg.FFmpegOption
import ffmpeg.FFmpegOptionType
import utils.colors.GREEN
import ytdlp.YtDlp
import ytdlp.YtDlpOption
import ytdlp.YtDlpOptionType

class Vitto : CliktCommand() {
    private val path by argument()
    private val quickFileName by argument().optional()

    private val resolution by option("-r", "--resolution", help = "The resolution to convert to. Uses width and scales according to the aspect ratio.")
    private val videoBitrate by option("-vb", "--videobitrate", help = "The video bitrate. Example: '96K' '9M'")
    private val audioBitrate by option("-ab", "--audiobitrate", help = "The audio bitrate. Example: '96K' '9M'")

    private val fileName by option("-n", "--filename", help = "The name that the resulting file should have.")
    private val outputPath by option("-o", "--outputPath", help = "The location where the file should be saved")
    private val useCookies by option("-c", "--useCookies", help = "Some websites require cookies (Twitter). Use this and provide your browser of choice. Example: -c firefox")

    override fun run() {
        if (path.isURL()) {
            runYtDlp()
        } else {
            runFFmpeg()
        }

        printlnClr("Done!", GREEN)
    }

    private fun runYtDlp() {
        val ytFileName = YtDlpOption(fileName, YtDlpOptionType.FILENAME)
        val ytOutputPath = YtDlpOption(outputPath, YtDlpOptionType.OUTPUT_PATH)
        val ytUseCookies = YtDlpOption(useCookies, YtDlpOptionType.COOKIES)

        val ytOptions = listOf(ytFileName, ytOutputPath, ytUseCookies)

        YtDlp.execute(ytOptions, path, quickFileName)
    }

    private fun runFFmpeg() {
        val ffResolution = FFmpegOption(resolution, FFmpegOptionType.RESOLUTION)
        val ffVideoBitrate = FFmpegOption(videoBitrate, FFmpegOptionType.VIDEO_BITRATE)
        val ffAudioBitrate = FFmpegOption(audioBitrate, FFmpegOptionType.AUDIO_BITRATE)

        val ffOptions = listOf(ffResolution, ffAudioBitrate, ffVideoBitrate)

        FFmpeg.execute(ffOptions, path)
    }

    private fun String.isURL(): Boolean {
        return this.substring(0,4) == "http"
    }
}