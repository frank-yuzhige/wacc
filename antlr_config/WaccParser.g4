parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

intsign: ADD | SUB;
integer: intsign? INTEGER;
ident  : IDENT;
boolLit: TRUE | FALSE;

type        : arrayType | baseType | pairType;
arrayType   : (baseType | pairType) (LBRA RBRA)+;
pairElemType: arrayType | baseType | PAIR;
baseType    : BASE_TYPE;
pairType    : PAIR LPAR first=pairElemType COMMA second=pairElemType RPAR;

unaryOp: NOT
       | LEN
       | ORD
       | CHR
       | SUB
       ;

pairElemFunc: FST | SND;


binop1: MUL | DIV | MOD;
binop2: ADD | SUB;
binop3: LTE | LT  | GTE | GT;
binop4: EQ  | NEQ;
binop5: AND;
binop6: OR;

expr: left=expr binop1 right=expr #exprBinop
    | left=expr binop2 right=expr #exprBinop
    | left=expr binop3 right=expr #exprBinop
    | left=expr binop5 right=expr #exprBinop
    | left=expr binop6 right=expr #exprBinop
    | left=expr binop4 right=expr #exprBinop
    | LPAR expr RPAR   #exprParens
    | integer          #exprInt
    | boolLit          #exprBool
    | CHARLIT          #exprChar
    | STRLIT           #exprString
    | NULL             #exprNull
    | ident            #exprIdent
    | unaryOp expr     #exprUnaryop
    | arrayElem        #exprArrElem
    ;

param    : type ident;
paramList: param (COMMA param)*;

func: type ident LPAR paramList? RPAR IS stats? END;

builtinFunc: FREE | RETURN | EXIT | PRINT | PRINTLN;

stat: SKIP_STAT                          #skip
    | type ident ASSIGN assignRhs        #declaration
    | assignLhs ASSIGN assignRhs         #assignment
    | READ assignLhs                     #readCall
    | builtinFunc expr                   #builtinFuncCall
    | IF expr THEN stats? ELSE stats? FI #condBranch
    | WHILE expr DO stats? DONE          #whileLoop
    | BEGIN stats? END                   #block
    ;

stats: stat (SEMICOLON stat)*;

assignLhs: ident
         | arrayElem
         | pairElem
         ;

assignRhs: expr                              #rhsExpr
         | arrayLiter                        #rhsArrayLiter
         | NEWPAIR LPAR expr COMMA expr RPAR #rhsNewPair
         | pairElem                          #rhsPairElem
         | CALL ident LPAR argList? RPAR     #rhsFuncCall
         ;

argList: expr (COMMA expr)*;

arrayLiter: LBRA argList? RBRA;

arrayElem: ident (LBRA expr RBRA)+;

pairElem: pairElemFunc expr;

// EOF indicates that the program must consume to the end of the input.
prog: BEGIN func* stats? END EOF;
