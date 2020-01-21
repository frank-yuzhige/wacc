parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

expr: LPAR expr RPAR
    | expr BINOP5 expr
    | expr BINOP4 expr
    | expr BINOP3 expr
    | expr BINOP2 expr
    | expr BINOP1 expr
    | INTEGER
    | TRUE
    | FALSE
    | CHARLIT
    | STRLIT
    | NULL
    | IDENT
    | arrayElem
    | UNARYOP expr
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
         | CALL IDENT LPAR RPAR
         | CALL IDENT LPAR argList RPAR
         ;

argList: expr (COMMA expr)*;

arrayLiter: LBRA RBRA
          | LBRA expr (COMMA expr)* RBRA;

arrayElem: IDENT (LBRA expr RBRA)+;

pairElem: (FST | SND) expr;

// EOF indicates that the program must consume to the end of the input.
prog: BEGIN (func)* (stat)+ END EOF ;
