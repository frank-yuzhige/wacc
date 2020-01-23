parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

intsign : ADD | SUB;
integer : intsign? INTEGER;

ident     : IDENT;

type        : arrayType | baseType | pairType;
arrayType   : (baseType | pairType) (LBRA RBRA)+;
pairElemType: arrayType | baseType | PAIR;
baseType    : BASE_TYPE;
pairType    : PAIR LPAR first=pairElemType COMMA second=pairElemType RPAR;

boolLit   : TRUE | FALSE;

unaryOp: NOT
       | LEN
       | ORD
       | CHR
       | FST
       | SND
       | SUB
       ;
       
binop1: MUL | DIV | MOD;
binop2: ADD | SUB;
binop3: LTE | LT  | GTE | GT;
binop4: EQ  | NEQ;
binop5: AND | OR;

expr     : expr (binop5 expr)+ #exprBinop
         | expr (binop4 expr)+ #exprBinop
         | expr (binop3 expr)+ #exprBinop
         | expr (binop2 expr)+ #exprBinop
         | expr (binop1 expr)+ #exprBinop
         | LPAR expr RPAR      #exprParens
         | integer             #exprInt
         | boolLit             #exprBool
         | CHARLIT             #exprChar
         | STRLIT              #exprString
         | NULL                #exprNull
         | ident               #exprIdent
         | unaryOp expr        #exprUnaryop
         | arrayElem           #exprArrElem
         ;

param : type ident;
paramList : param (COMMA param)*;

func: type ident LPAR paramList? RPAR IS stats END;

builtinFunc: FREE | RETURN | EXIT | PRINT | PRINTLN;

stat: SKIP_STAT                        #skip
    | type ident ASSIGN assignRhs      #declaration
    | assignLhs ASSIGN assignRhs       #assignment
    | READ assignLhs                   #readCall
    | builtinFunc expr                 #builtinFuncCall
    | IF expr THEN stats ELSE stats FI #condBranch
    | WHILE expr DO stats DONE         #whileLoop
    | BEGIN stats END                  #block
    ;

stats: (stat (SEMICOLON stat)*)?;

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

pairElemFunc: FST | SND;

pairElem: pairElemFunc expr;

// EOF indicates that the program must consume to the end of the input.
prog: BEGIN func* stats END EOF;
