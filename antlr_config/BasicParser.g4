parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

binaryOper: BINOP ;

expr:
    | INTEGER
    | TRUE
    | FALSE
    | CHARLIT
    | STRLIT
    | IDENT
    | arrayElem
    | UNARYOP expr
    | expr BINOP expr
    | LPAR expr RPAR
    ;

func: TYPE IDENT;

stat: SKIP_STAT
    | TYPE IDENT ASSIGN assignRhs
    | assignLhs ASSIGN assignRhs
    | READ assignRhs
    | (FREE | RETURN | EXIT | PRINT | PRINTLN) expr
    | IF expr THEN stat ELSE stat FI
    | WHILE expr DO stat DONE
    | BEGIN stat END
    | stat SEMICOLON stat
    ;

assignLhs: IDENT
         | arrayElem
         | pairElem
         ;

assignRhs: expr
         | arrayLiter
         | NEWPAIR LPAR expr COMMA expr RPAR
         | pairElem
         | CALL IDENT LPAR (argList)? RPAR
         ;

argList: expr (COMMA expr)*;

arrayLiter: LBRA (expr (COMMA expr)*)? RBRA;

arrayElem: IDENT (LBRA expr RBRA)+;

pairElem: (FST | SND) expr;



// EOF indicates that the program must consume to the end of the input.
prog: BEGIN (func)* (stat)+ END EOF ;
