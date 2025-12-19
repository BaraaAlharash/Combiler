parser grammar PythonParser;

options { tokenVocab=PythonLexer; }

program
  : (statement | NEWLINE)* EOF
  ;

statement
  : simple_statement NEWLINE?
  | compound_statement
  ;

simple_statement
  : assignment
  | print_stmt
  | expr
  ;

compound_statement
  : if_stmt
  | while_stmt
  | for_stmt
  | func_def
  ;

if_stmt
  : IF expr COLON NEWLINE block
    (ELIF expr COLON NEWLINE block)*
    (ELSE COLON NEWLINE block)?
  ;

while_stmt
  : WHILE expr COLON NEWLINE block
  ;

for_stmt
  : FOR NAME IN expr COLON NEWLINE block
  ;

func_def
  : DEF NAME LPAREN (param (COMMA param)*)? RPAREN COLON NEWLINE block
  ;

param
  : NAME
  ;

block
  : statement+   // simplified block
  ;

// ---- expressions ----
expr
  : or_test
  ;

or_test
  : and_test (OR and_test)*
  ;

and_test
  : not_test (AND not_test)*
  ;

not_test
  : NOT not_test
  | comparison
  ;

comparison
  : arith ( (EQ | GT | LT) arith )*
  ;

arith
  : term ((PLUS | MINUS) term)*
  ;

term
  : factor ((STAR | SLASH) factor)*
  ;

factor
  : LPAREN expr RPAREN
  | NAME
  | NUMBER
  | STRING
  | func_call
  ;

func_call
  : NAME LPAREN (expr (COMMA expr)*)? RPAREN
  ;

print_stmt
  : PRINT LPAREN expr RPAREN
  ;

assignment
  : NAME ASSIGN expr
  ;