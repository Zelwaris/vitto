abstract class FFmpeg {
    companion object {
        fun execute(path: String, resolution: String?) {
            //TODO Get list of commands and use string builder to build command
            "ffmpeg -i $path -filter:v scale=${resolution ?: "1920"}:-1 -c:a copy output.mp4".runCommand()
        }
    }
}