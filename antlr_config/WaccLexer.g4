lexer grammar WaccLexer;

// binary operators
ADD: '+' ;
SUB: '-' ;
MUL: '*' ;
DIV: '/' ;
MOD: '%' ;
GTE: '>=';
GT : '>' ;
LTE: '<=';
LT : '<' ;
EQ : '==';
NEQ: '!=';
AND: '&&';
OR : '||';

BINOP1: MUL | DIV | MOD;
BINOP2: ADD | SUB;
BINOP3: LTE | LT  | GTE | GT;
BINOP4: EQ  | NEQ;
BINOP5: AND | OR;
// BINOP : ADD | SUB | MUL | DIV | MOD | GTE | GT | LTE | LT | EQ | NEQ | AND | OR;

// unary operators
NOT: '!';
LEN: 'len';
ORD: 'ord';
CHR: 'chr';
FST: 'fst';
SND: 'snd';

// skip
SKIP_STAT: 'skip';

// brackets
LPAR: '(' ;
RPAR: ')' ;
LBRA: '[' ;
RBRA: ']' ;
LCUR: '{' ;
RCUR: '}' ;

// semicolon
SEMICOLON: ';';

// key words
BEGIN: 'begin';
IS: 'is';
END: 'end';
NULL: 'null';
TRUE: 'true';
FALSE: 'false';
IF: 'if';
THEN: 'then';
ELSE: 'else';
FI: 'fi';
WHILE: 'while';
DO: 'do';
DONE: 'done';
NEWPAIR: 'newpair';
READ: 'read';
FREE: 'free';
RETURN: 'return';
EXIT: 'exit';
PRINT: 'print';
PRINTLN: 'println';
CALL: 'call';
PAIR: 'pair';

//TYPE: PAIR_TYPE | ARR_TYPE | BASE_TYPE;

//fragment PAIR_ELEM_TYPE: 'pair' | ARR_TYPE | BASE_TYPE;
//fragment PAIR_TYPE: 'pair' WS? '(' PAIR_ELEM_TYPE ',' WS? PAIR_ELEM_TYPE ')';
//fragment ARR_TYPE: BASE_TYPE ('[]')+;
BASE_TYPE: 'int' | 'string' | 'bool' | 'char';



// numbers
fragment DIGIT: '0'..'9' ;
INTEGER: ('+'|'-')? DIGIT+ ;

// string literal
STRLIT: '"' (NORMAL_CHAR | ESC_CHAR)* '"';
CHARLIT: '\'' (NORMAL_CHAR | ESC_CHAR) '\'';

fragment NORMAL_CHAR: ~('\\' | '\'' | '"');
fragment ESC_CHAR: '\\'('0' | 'b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\');

// other tokens
ASSIGN: '=';
COMMA: ',';

// idents
fragment IDENT_HEAD: 'A'..'Z' | 'a'..'z' | '_';
fragment IDENT_TAIL: IDENT_HEAD | DIGIT;

IDENT: IDENT_HEAD IDENT_TAIL*;

// comments
COMMENT: '#' ~('\r' | '\n')* -> skip;
WS: [ \t\n\r]+ -> skip;