lexer grammar CssLexer;

COMMENT : '/*' .*? '*/' -> skip ;

COLON      : ':' ;
SEMICOLON  : ';' ;
LBRACE     : '{' ;
RBRACE     : '}' ;
DOT        : '.' ;
HASH       : '#' ;
COMMA      : ',' ;
STAR       : '*' ;
PLUS       : '+' ;
GREATER    : '>' ;
TILDE      : '~' ;
EQUALS     : '=' ;
OPEN_PAREN : '(' ;
CLOSE_PAREN: ')' ;


IMPORTANT : '!' 'important' ;
AT_RULE   : '@' [a-zA-Z_-]+ ;

NUMBER     : [0-9]+ ('.' [0-9]+)? ;
PERCENTAGE : NUMBER '%' ;
DIMENSION  : NUMBER [a-zA-Z]+ ;
STRING     : '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'' ;

IDENT : '-'? [a-zA-Z_] [a-zA-Z0-9_-]* ;

WS : [ \t\r\n]+ -> skip ;
