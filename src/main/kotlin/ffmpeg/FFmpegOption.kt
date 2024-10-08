package ffmpeg

import ffmpeg.FFmpegOptionType.*

class FFmpegOption(
    value: String?,
    private val type: FFmpegOptionType
) {
    val value = value
        get() {
            if (field == null)
                return null

            return when (type) {
                RESOLUTION -> "-filter:v scale=$field:-1"
                VIDEO_BITRATE -> "-b:v $field"
                AUDIO_BITRATE -> "-b:a $field"
            }
        }
}