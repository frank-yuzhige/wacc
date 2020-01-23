parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

ident     : IDENT;

type        : arrayType | baseType | pairType;
arrayType   : baseType (LBRA RBRA)+;
pairElemType: arrayType | baseType | PAIR;
baseType    : BASE_TYPE;
pairType    : PAIR LPAR pairElemType COMMA pairElemType RPAR;

boolLit   : TRUE | FALSE;

expr     : binExpr4 (BINOP5 binExpr4)*;
binExpr4 : binExpr3 (BINOP4 binExpr3)*;
binExpr3 : binExpr2 (BINOP3 binExpr2)*;
binExpr2 : binExpr1 (BINOP2 binExpr1)*;
binExpr1 : atomExpr (BINOP1 atomExpr)*;
atomExpr : LPAR expr RPAR
         | INTEGER
         | boolLit
         | CHARLIT
         | STRLIT
         | NULL
         | ident
         | arrayElem
         | UNARYOP expr
         ;

param : type ident;
paramList : param (COMMA param)*;

func: type ident LPAR paramList? RPAR IS stats END;

stat: SKIP_STAT
    | type ident ASSIGN assignRhs
    | assignLhs ASSIGN assignRhs
    | READ assignRhs
    | (FREE | RETURN | EXIT | PRINT | PRINTLN) expr
    | IF expr THEN stats ELSE stats FI
    | WHILE expr DO stats DONE
    | BEGIN stats END
    ;

stats: (stat (SEMICOLON stat)*)?;

assignLhs: ident
         | arrayElem
         | pairElem
         ;

assignRhs: expr
         | arrayLiter
         | NEWPAIR LPAR expr COMMA expr RPAR
         | pairElem
         | CALL ident LPAR RPAR
         | CALL ident LPAR argList RPAR
         ;

argList: expr (COMMA expr)*;

arrayLiter: LBRA RBRA
          | LBRA expr (COMMA expr)* RBRA;

arrayElem: ident (LBRA expr RBRA)+;

pairElem: (FST | SND) expr;

// EOF indicates that the program must consume to the end of the input.
prog: BEGIN func* stats END EOF;
