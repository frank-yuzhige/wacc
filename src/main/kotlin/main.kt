import java.io.File

fun main(args: Array<String>) {
    val process = ProcessBuilder("cmd", "/c", "ruby", "refEmulate", "test.s").start()
    println(process.inputStream.reader(Charsets.UTF_8).readText())
    process.waitFor()
}