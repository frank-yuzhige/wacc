package utils

import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

class RefCompiler() {
    data class RefCompilerOutput(val output: String, val exitCode: Int)
    companion object {
        fun getRefCompilerOutput(file: File, inputData: List<String>): RefCompilerOutput {
            val process = ProcessBuilder("ruby", "refCompile", "-x", file.absolutePath).start()
            val writer = BufferedWriter(OutputStreamWriter(process.outputStream))
            if (inputData.isNotEmpty()) {
                for (line in inputData) {
                    writer.write(line)
                    writer.flush()
                }
            } else {
                writer.newLine()
            }
            writer.close()
            val expectedOutput = process.inputStream.reader(Charsets.UTF_8).readText()
            process.waitFor()
            val pureOutputRegex = """={59}\n([\s\S]*)={59}""".toRegex()
            val matchResult: MatchResult? = pureOutputRegex.find(expectedOutput)
            var resultString: String? = null
            if (matchResult != null) {
                val addressRegex = """0x\w{5,8}""".toRegex()
                resultString = matchResult.groups[1]!!.value.replace(addressRegex, "0x*****")
            }
            val exitCodeRegex = """exit code is (\d+)""".toRegex()
            val exitCodeMatchResult = exitCodeRegex.find(expectedOutput)
            return RefCompilerOutput(resultString ?: "", exitCodeMatchResult!!.groups[1]!!.value.toInt())
        }
    }
}