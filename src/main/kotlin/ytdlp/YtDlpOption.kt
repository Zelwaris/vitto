package ytdlp

import ytdlp.YtDlpOptionType.*

class YtDlpOption(
    value: String?,
    val type: YtDlpOptionType
) {
    val value = value
        get() {
            if (field == null)
                return null

            return when (type) {
                FILENAME -> field
                OUTPUT_PATH -> field
                COOKIES -> "--cookies-from-browser $field"
            }
        }

    override fun toString(): String {
        return value ?: ""
    }
}