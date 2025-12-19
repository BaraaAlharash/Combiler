lexer grammar CssLexer;

// التعليقات
COMMENT : '/*' .*? '*/' -> skip ;

// الرموز الأساسية
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

// الكلمات المفتاحية
IMPORTANT : '!' 'important' ;
AT_RULE   : '@' [a-zA-Z_-]+ ;

// القيم
NUMBER     : [0-9]+ ('.' [0-9]+)? ;
PERCENTAGE : NUMBER '%' ;
DIMENSION  : NUMBER [a-zA-Z]+ ;
STRING     : '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'' ;

// المعرفات
IDENT : '-'? [a-zA-Z_] [a-zA-Z0-9_-]* ;

// المسافات
WS : [ \t\r\n]+ -> skip ;
