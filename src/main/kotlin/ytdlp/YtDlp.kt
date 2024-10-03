package ytdlp

import printlnClr
import runCommand
import utils.colors.CYAN
import ytdlp.YtDlpOptionType.FILENAME
import ytdlp.YtDlpOptionType.OUTPUT_PATH

class YtDlp {
    companion object {
        fun execute(input: List<YtDlpOption>, path: String, quickFileName: String?) {
            val options = input.filterNot { it.type == FILENAME || it.type == OUTPUT_PATH }

            val fileName = getFileName(input.find { it.type == FILENAME }, quickFileName)
            val outputPath = input.find { it.type == OUTPUT_PATH }

            val formattedOutputPath: String = buildFormattedOutputPath(fileName, outputPath)

            printlnClr("yt-dlp step starting for $CYAN$path")
            "yt-dlp $path ${options.joinToString(" ")} $formattedOutputPath".runCommand()
        }

        private fun getFileName(fileName: YtDlpOption?, quickFileName: String?): String {
            if (quickFileName != null) {
                return quickFileName
            }

            if (fileName != null) {
                if (fileName.value != null) {
                    return fileName.toString()
                }
            }

            return ""
        }

        private fun buildFormattedOutputPath(fileName: String, outputPath: YtDlpOption?): String {
            if (outputPath == null && fileName.isEmpty()) {
                return ""
            }
            if (outputPath == null) {
                return "-o $fileName.%(ext)s"
            }
            if (fileName.isEmpty()) {
                return "-o $outputPath"
            }
            return "-o $outputPath$fileName.%(ext)s"
        }
    }
}