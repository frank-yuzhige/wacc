import java.io.File
import java.nio.file.Files

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        val file : File = File(args[0])
        if (file.isFile) {
            val lines : List<String> = Files.readAllLines(file.toPath())

            var lineNo = 0
            for (line : String in lines) {
                println("" + lineNo + " " + line)
                lineNo++
            }
        } else {
            println("File not found at path " + args[0])
        }
    }
}