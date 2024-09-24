abstract class FFmpeg {
    companion object {
        fun execute(input: List<FFmpegOption>, path: String) {
            val options = input.mapNotNull { it.value }

            println("FFmpeg step starting for $CYAN$path", RESET)
            "ffmpeg -loglevel error -y -i $path ${options.joinToString(" ")} -c:a copy output.mp4".runCommand()
        }
    }
}