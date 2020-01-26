import java.io.InputStream

fun toInputStream(input: Any) : InputStream = input.toString().byteInputStream()