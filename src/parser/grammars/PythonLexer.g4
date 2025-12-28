
lexer grammar PythonLexer;

options {
    superClass = PythonLexerBase;
}


// ============================================= Python Lexer ==============================================

WS      : [ \t]+ -> skip ;
NEWLINE : ('\r'? '\n')+ ;

// keywords
DEF   : 'def' ;
IF    : 'if' ;
ELIF  : 'elif' ;
ELSE  : 'else' ;
WHILE : 'while' ;
FOR   : 'for' ;
IN    : 'in' ;
PRINT : 'print' ;

OR    : 'or' ;
AND   : 'and' ;
NOT   : 'not' ;

// operators / delimiters
ASSIGN : '=' ;
EQ     : '==' ;
GT     : '>' ;
LT     : '<' ;
PLUS   : '+' ;
MINUS  : '-' ;
STAR   : '*' ;
SLASH  : '/' ;

LPAREN : '(' ;
RPAREN : ')' ;
COLON  : ':' ;
COMMA  : ',' ;

// literals
NUMBER : [0-9]+ ('.' [0-9]+)? ;

STRING
  : '"' ( '\\' . | ~["\\\r\n] )* '"'
  | '\'' ( '\\' . | ~['\\\r\n] )* '\''
  ;

NAME   : [a-zA-Z_] [a-zA-Z0-9_]* ;