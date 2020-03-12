package utils

import java.io.File
import java.io.InputStream

fun toInputStream(input: Any) : InputStream = input.toString().byteInputStream()

fun<A, B, C> cartesianBy(fst : Iterable<A>,
                         snd : Iterable<B>,
                         productFunc : (A, B) -> C ) : Iterable<C> {
    return fst.flatMap { x -> snd.map { y -> productFunc(x, y) } }
}

fun<A, B> cartesianProduct(fst : Iterable<A>, snd : Iterable<B>)
        = cartesianBy(fst, snd) { x, y -> x to y }

fun excludedFiles() = setOf(
        "src/test/resources/valid/advanced/ticTacToe.wacc",
        "src/test/resources/valid/mine/varvarvar.wacc",
        "src/test/resources/valid/mine/kata.wacc",
        "src/test/resources/valid/advanced/binarySortTree.wacc",
        "src/test/resources/valid/advanced/hashTable.wacc",
        "src/test/resources/valid/pairs/linkedList.wacc",
        "src/test/resources/valid/pairs/null.wacc",
        "src/test/resources/valid/pairs/printNull.wacc",
        "src/test/resources/valid/pairs/printNullPair.wacc",
        "src/test/resources/valid/pairs/printPairOfNulls.wacc",
        "src/test/resources/valid/runtimeErr/nullDereference/freeNull.wacc",
        "src/test/resources/invalid/syntaxErr/function/funcExpr.wacc",
        "src/test/resources/invalid/syntaxErr/function/funcExpr2.wacc",
        "src/test/resources/invalid/semanticErr/multiple/multiCaseSensitivity.wacc",
        "src/test/resources/invalid/syntaxErr/function/functionMissingCall.wacc",
        "src/test/resources/invalid/syntaxErr/if/ifNoelse.wacc",
        "src/test/resources/invalid/syntaxErr/print/printlnCharArry.wacc",
        "src/test/resources/invalid/semanticErr/variables/caseMatters.wacc",
        "src/test/resources/invalid/syntaxErr/sequence/extraSeq.wacc"

)

