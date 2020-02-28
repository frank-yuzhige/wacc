parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

intsign : ADD | SUB;
integer : intsign? INTEGER;
ident   : IDENT;
capIdent: CAP_IDENT;
boolLit : TRUE | FALSE;

type        : arrayType | baseType | pairType | capIdent;
arrayType   : (baseType | pairType) (LBRA RBRA)+;
pairElemType: arrayType | baseType | PAIR;
baseType    : BASE_TYPE;
pairType    : PAIR LPAR first=pairElemType COMMA second=pairElemType RPAR;

member: type ident;
newtype: structType | taggedUnion;
structType: NEWTYPE capIdent IS (member SEMICOLON)* END;

unionEntry: capIdent (OF LPAR member (COMMA member)* RPAR)?;
taggedUnion: NEWTYPE capIdent IS UNION (unionEntry SEMICOLON)* END;

enumRange: from=expr DOTDOT to=expr                 #rangeFromTo
         | from=expr COMMA then=expr DOTDOT to=expr #rangeFromThenTo
         ;

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

expr: left=expr binop1 right=expr    #exprBinop
    | left=expr binop2 right=expr    #exprBinop
    | left=expr binop3 right=expr    #exprBinop
    | left=expr binop4 right=expr    #exprBinop
    | left=expr binop5 right=expr    #exprBinop
    | left=expr binop6 right=expr    #exprBinop
    | LPAR expr RPAR                 #exprParens
    | ident LPAR argList RPAR        #exprFuncCall
    | IF cond=expr THEN tr=expr ELSE fl=expr FI #exprIf
    | integer                        #exprInt
    | boolLit                        #exprBool
    | CHARLIT                        #exprChar
    | STRLIT                         #exprString
    | NULL                           #exprNull
    | unaryOp expr                   #exprUnaryop
    | arrayElem                      #exprArrElem
    | ident                          #exprIdent
    ;

param    : type ident;
paramList: param (COMMA param)*;

func: type ident LPAR paramList? RPAR IS stats END;

builtinFunc: FREE | RETURN | EXIT | PRINT | PRINTLN;

stat: SKIP_STAT                                         #skip
    | (type|VAR) ident ASSIGN assignRhs                 #declaration
    | CONST type? ident ASSIGN assignRhs                #constDeclaration
    | assignLhs ASSIGN assignRhs                        #assignment
    | READ assignLhs                                    #readCall
    | builtinFunc expr                                  #builtinFuncCall
    | IF expr THEN stats?
        ((ELSE IF expr THEN stats)* ELSE stats?)? FI    #condBranch
    | WHILE expr DO stats? DONE                         #whileLoop
    | FOR (type|VAR)? ident IN enumRange DO stats? DONE #forLoop
    | WHEN expr COLON whenCase* END                     #whenClause
    | BEGIN stats? END                                  #block
    ;

pattern:  capIdent (LPAR ident (COMMA ident)* RPAR)?;
whenCase: IS pattern ARROW stats;

stats: stat SEMICOLON (stat SEMICOLON)*;

assignLhs: ident
         | arrayElem
         | pairElem
         | typeMember
         ;

assignRhs: expr                              #rhsExpr
         | arrayLiter                        #rhsArrayLiter
         | NEWPAIR LPAR expr COMMA expr RPAR #rhsNewPair
         | pairElem                          #rhsPairElem
         | typeMember                        #rhsTypeMember
         | typeConstructor                   #rhsTypeConstructor
         | CALL ident LPAR argList? RPAR     #rhsFuncCall
         ;

argList: expr (COMMA expr)*;

arrayLiter: LBRA argList? RBRA;

arrayElem: ident (LBRA expr RBRA)+;

pairElem: pairElemFunc expr;

typeMember: expr DOT ident;

typeConstructor: capIdent LPAR argList? RPAR;

// EOF indicates that the program must consume to the end of the input.
prog: BEGIN newtype* func* stats? END EOF;
