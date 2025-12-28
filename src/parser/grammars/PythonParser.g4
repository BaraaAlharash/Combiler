parser grammar PythonParser;

options { tokenVocab=PythonLexer; }

program
  : (statement | NEWLINE)* EOF                   #ProgramRule
  ;

statement
  : simple_statement NEWLINE?                    #SimpleStatementRule
  | compound_statement                           #CompoundStatementRule
  ;

simple_statement
  : assignment                                   #AssignmentStatement
  | print_stmt                                   #PrintStatement
  | expr                                         #ExpressionStatement
  ;

compound_statement
  : if_stmt                                      #IfStatement
  | while_stmt                                   #WhileStatement
  | for_stmt                                     #ForStatement
  | func_def                                     #FunctionDefinition
  ;

if_stmt
  : IF expr COLON NEWLINE block
    (ELIF expr COLON NEWLINE block)*
    (ELSE COLON NEWLINE block)?                  #IfStatementRule
  ;

while_stmt
  : WHILE expr COLON NEWLINE block               #WhileStatementRule
  ;

for_stmt
  : FOR NAME IN expr COLON NEWLINE block         #ForStatementRule
  ;

func_def
  : DEF NAME LPAREN (param (COMMA param)*)? RPAREN COLON NEWLINE block
                                                #FunctionDefRule
  ;

param
  : NAME                                        #ParameterRule
  ;

block
  : statement+                                  #BlockRule
  ;

// ---- expressions ----
expr
  : or_test                                     #OrTestExpression
  ;

or_test
  : and_test (OR and_test)*                     #OrTestRule
  ;

and_test
  : not_test (AND not_test)*                    #AndTestRule
  ;

not_test
  : NOT not_test                                #NotExpression
  | comparison                                  #ComparisonExpression
  ;

comparison
  : arith ( (EQ | GT | LT) arith )*             #ComparisonRule
  ;

arith
  : term ((PLUS | MINUS) term)*                 #ArithmeticExpression
  ;

term
  : factor ((STAR | SLASH) factor)*             #TermExpression
  ;

factor
  : LPAREN expr RPAREN                          #ParenExpression
  | NAME                                        #NameExpression
  | NUMBER                                      #NumberExpression
  | STRING                                      #StringExpression
  | func_call                                   #FunctionCallExpression
  ;

func_call
  : NAME LPAREN (expr (COMMA expr)*)? RPAREN    #FunctionCallRule
  ;

print_stmt
  : PRINT LPAREN expr RPAREN                    #PrintStatementRule
  ;

assignment
  : NAME ASSIGN expr                            #AssignmentRule
  ;








//  # simple test program
//  price = 100
//  tax = 0.15
//  total = price + price * tax
//
//  if total > 100:
//      status = "expensive"
//  else:
//      status = "cheap"
//
//  for i in range(3):
//      total = total + i

