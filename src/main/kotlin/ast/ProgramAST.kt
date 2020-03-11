package ast

import utils.Statements
import utils.prettyPrint

data class ProgramAST(val newTypes: List<NewTypeDef>,
                      val traits: List<TraitDef>,
                      val instances: List<TraitInstance>,
                      val functions: List<Function>,
                      val mainProgram: Statements) : WaccAST() {
    override fun prettyPrint(): String {
        val nts = if (newTypes.isEmpty()) "" else
            newTypes.joinToString("\n" , postfix = "\n\n") { it.prettyPrint().prependIndent() }
        val tts = if(traits.isEmpty()) "" else
            traits.joinToString("\n", postfix = "\n\n") { it.prettyPrint().prependIndent() }
        val its = if(instances.isEmpty()) "" else
            instances.joinToString("\n", postfix = "\n\n") { it.prettyPrint().prependIndent() }
        return "begin\n" +
                tts + nts + its +
                functions.joinToString("\n") { it.prettyPrint().prependIndent() } +
                (if (functions.isNotEmpty()) "\n" else "") +
                "${mainProgram.prettyPrint().prependIndent()}\n" +
                "end"
    }

    override fun tellIdentity(): String = "a program"
}