import parser.Parser

fun main(args: Array<String>) {

    val prog2 = "int[][][][]"
    println(Parser(prog2.byteInputStream()).doParse().type().arrayType().LBRA().size)
}