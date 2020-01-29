package ast

import utils.Parameter

fun Parameter.getVar() = this.first
fun Parameter.getType() = this.second