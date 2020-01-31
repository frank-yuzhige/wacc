package utils

import ast.Type
import ast.WaccAST
import utils.Attributes
import java.util.*

typealias Index = Pair<Int, Int>
typealias AstIndexMap = IdentityHashMap<WaccAST, Index>
typealias Parameter = Pair<String, Type>