package ffmpeg

import printlnClr
import runCommand
import utils.colors.CYAN

abstract class FFmpeg {
    companion object {
        fun execute(input: List<FFmpegOption>, path: String) {
            val options = input.mapNotNull { it.value }

            printlnClr("FFmpeg step starting for $CYAN$path")
            "ffmpeg -loglevel error -y -i $path ${options.joinToString(" ")} -c:a copy output.mp4".runCommand()
        }
    }
}