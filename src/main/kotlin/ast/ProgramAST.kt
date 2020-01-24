package ast

data class ProgramAST (val functions: List<Function>, val mainProgram : Statements) : WaccAST