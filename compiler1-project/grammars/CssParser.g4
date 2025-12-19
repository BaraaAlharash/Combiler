parser grammar CssParser;

options { tokenVocab= CssLexer; }

// نقطة البداية
stylesheet
    : (statement | atRule)* EOF
    ;

statement
    : selectorGroup LBRACE declarationList? RBRACE
    ;

selectorGroup
    : selector (COMMA selector)*
    ;

selector
    : simpleSelector (combinator simpleSelector)*
    ;

simpleSelector
    : (IDENT | HASH IDENT | DOT IDENT | STAR)
    ;

combinator
    : PLUS | GREATER | TILDE
    ;

declarationList
    : declaration (SEMICOLON declaration)* SEMICOLON?
    ;

declaration
    : property COLON value (IMPORTANT)?
    ;

property
    : IDENT
    ;

value
    : valueItem+
    ;

valueItem
    : IDENT
    | NUMBER
    | PERCENTAGE
    | DIMENSION
    | STRING
    | HASH
    | OPEN_PAREN value CLOSE_PAREN
    | COMMA
    | STAR
    | PLUS
    | MINUS
    ;

atRule
    : AT_RULE (IDENT | STRING)* SEMICOLON
    ;
