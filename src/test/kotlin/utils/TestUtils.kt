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
        File("src/test/resources/valid/advanced/ticTacToe.wacc"),
        File("src/test/resources/valid/mine/varvarvar.wacc"),
        File("src/test/resources/valid/mine/kata.wacc"),
        File("src/test/resources/valid/advanced/binarySortTree.wacc"),
        File("src/test/resources/valid/advanced/hashTable.wacc"),
        File("src/test/resources/valid/pairs/linkedList.wacc"),
        File("src/test/resources/valid/pairs/null.wacc"),
        File("src/test/resources/valid/pairs/printNull.wacc"),
        File("src/test/resources/valid/pairs/printNullPair.wacc"),
        File("src/test/resources/valid/pairs/printPairOfNulls.wacc"),
        File("src/test/resources/valid/pairs/readPair.wacc"),
        File("src/test/resources/valid/pairs/writeFst.wacc"),
        File("src/test/resources/valid/pairs/writeSnd.wacc"),
        File("src/test/resources/valid/runtimeErr/nullDereference/freeNull.wacc"),
        File("src/test/resources/invalid/syntaxErr/function/funcExpr.wacc"),
        File("src/test/resources/invalid/syntaxErr/function/funcExpr2.wacc"),
        File("src/test/resources/invalid/semanticErr/multiple/multiCaseSensitivity.wacc"),
        File("src/test/resources/invalid/syntaxErr/function/functionMissingCall.wacc"),
        File("src/test/resources/invalid/syntaxErr/if/ifNoelse.wacc"),
        File("src/test/resources/invalid/syntaxErr/print/printlnCharArry.wacc"),
        File("src/test/resources/invalid/semanticErr/variables/caseMatters.wacc"),
        File("src/test/resources/invalid/syntaxErr/sequence/extraSeq.wacc")
)

fun cleanUp() {
    val tempFiles: List<File> = listOf(File("src/test/kotlin/utils/temp"),
            File("src/test/kotlin/utils/temp.s"))
    tempFiles.forEach {
        if (it.exists()) { it.delete() }
    }
}
