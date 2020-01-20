lexer grammar BasicLexer;

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

BINOP: ADD | SUB | MUL | DIV | MOD | GTE | GT | LTE | LT | EQ | NEQ | AND | OR;

// unary operators
NOT: '!';
LEN: 'len';
ORD: 'ord';
CHR: 'chr';
FST: 'fst';
SND: 'snd';

UNARYOP: NOT
       | LEN
       | ORD
       | CHR
       | FST
       | SND
       ;

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

// comments
COMMENT: '#' ~('\r' | '\n')*;

// idents
fragment IDENT_HEAD: 'A'..'Z' | 'a'..'z' | '_';
fragment IDENT_TAIL: IDENT_HEAD | DIGIT;

IDENT: IDENT_HEAD IDENT_TAIL*;

fragment BASE_TYPE: 'int' | 'string' | 'bool' | 'char';
fragment ARR_TYPE: BASE_TYPE ('[]')+;
fragment PAIR_ELEM_TYPE: ARR_TYPE | BASE_TYPE | 'pair';
fragment PAIR_TYPE: 'pair' LPAR PAIR_ELEM_TYPE ',' PAIR_ELEM_TYPE RPAR;
TYPE: PAIR_TYPE | ARR_TYPE | BASE_TYPE;

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


// numbers
fragment DIGIT: '0'..'9' ;
INTEGER: ('+'|'-')? DIGIT+ ;

// string literal
STRLIT: '"' (NORMAL_CHAR | ESC_CHAR)* '"';
CHARLIT: '\'' (NORMAL_CHAR | ESC_CHAR) '\'';

NORMAL_CHAR: ~('\\' | '\'' | '"');
ESC_CHAR: '\\'('0' | 'b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\');

// other tokens
ASSIGN: '=';
COMMA: ',';
