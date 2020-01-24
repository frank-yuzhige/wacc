import parser.Parser
import parser.toAST

fun main(args: Array<String>) {

    val prog2 = "!true"
    println(Parser(prog2.byteInputStream()).doParse().unaryOp().text)
    println(Parser("begin int func(int x) is int k = x + 1; bool b = x == k; return k end int c = call func(4); return c end".byteInputStream())
            .doParse().prog().toAST())
}