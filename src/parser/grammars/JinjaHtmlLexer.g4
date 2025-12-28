lexer grammar JinjaHtmlLexer;

VAR_OPEN  : '{{' -> pushMode(JINJA);
STMT_OPEN : '{%' -> pushMode(JINJA);

XML   : '<?xml' .*? '?>' ;
DTD   : '<!DOCTYPE' .*? '>' ;
CDATA : '<![CDATA[' .*? ']]>' ;

HTML_CONDITIONAL_COMMENT : '<![' .*? ']>' ;
HTML_COMMENT             : '<!--' .*? '-->' ;

SCRIPTLET : '<%' .*? '%>' ;

// script/style - TAG_OPEN
SCRIPT_OPEN : '<script' .*? '>' -> pushMode(SCRIPT_MODE);
STYLE_OPEN  : '<style'  .*? '>' -> pushMode(STYLE_MODE);

TAG_OPEN : '<' -> pushMode(TAG_MODE);

SEA_WS : [ \t\r\n]+ ;  // skip

TEXT : ~[<{}%]+ ;


// =====================
// TAG MODE
// =====================
mode TAG_MODE;

TAG_SLASH_CLOSE : '/>' -> popMode ;
TAG_CLOSE       : '>'  -> popMode ;

TAG_SLASH  : '/' ;

TAG_EQUALS : '=' -> pushMode(ATTR_VALUE_MODE);

TAG_NAME : [a-zA-Z_:] [a-zA-Z0-9_:\-.]* ;

TAG_WS : [ \t\r\n]+ -> skip ;


// =======================
// ATTR VALUE MODE
// =======================

mode ATTR_VALUE_MODE;

ATTVALUE_VALUE
  : '"'  (~["\\] | '\\' .)* '"'
  | '\'' (~['\\] | '\\' .)* '\''
  | ~[ \t\r\n>]+
  ;

ATTR_WS : [ \t\r\n]+ -> skip ;

ATTR_END
  : '>'  -> popMode, popMode
  ;

ATTR_SLASH_CLOSE
  : '/>' -> popMode, popMode
  ;


// =====================
// JINJA MODE
// =====================
mode JINJA;

VAR_CLOSE  : '}}' -> popMode ;
STMT_CLOSE : '%}' -> popMode ;

JINJA_WS : [ \t\r\n]+ -> skip ;

IF     : 'if';
ELIF   : 'elif';
ELSE   : 'else';
ENDIF  : 'endif';

FOR    : 'for';
IN     : 'in';
ENDFOR : 'endfor';

SET    : 'set';

OR  : 'or';
AND : 'and';
NOT : 'not';

TRUE  : 'true' | 'True';
FALSE : 'false' | 'False';
NONE  : 'none' | 'None';

EQ : '==';
NE : '!=';
LE : '<=';
GE : '>=';

LT : '<';
GT : '>';

ASSIGN : '=';

ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MOD : '%';

DOT : '.';

OPEN_PAREN    : '(';
CLOSE_PAREN   : ')';
OPEN_BRACKET  : '[';
CLOSE_BRACKET : ']';

NUMBER : [0-9]+ ('.' [0-9]+)? ;

STRING
  : '"'  (~["\\] | '\\' .)* '"'
  | '\'' (~['\\] | '\\' .)* '\''
  ;

NAME : [a-zA-Z_][a-zA-Z_0-9]* ;


// =====================
// SCRIPT MODE
// =====================
mode SCRIPT_MODE;

SCRIPT_BODY       : .*? '</script' .*? '>' -> popMode ;
SCRIPT_SHORT_BODY : '</script' .*? '>' -> popMode ;


// =====================
// STYLE MODE
// =====================
mode STYLE_MODE;

STYLE_BODY       : .*? '</style' .*? '>' -> popMode ;
STYLE_SHORT_BODY : '</style' .*? '>' -> popMode ;
