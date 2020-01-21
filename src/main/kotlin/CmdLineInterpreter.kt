import java.io.File
import java.nio.file.Files

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        val file = File(args[0])
        if (file.isFile) {
            val lines : List<String> = Files.readAllLines(file.toPath())

            for ((lineNo, line : String) in lines.withIndex()) {
                println("$lineNo $line")
            }
        } else {
            println("File not found at path " + args[0])
        }
    }
}