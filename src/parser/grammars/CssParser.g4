parser grammar CssParser;

options { tokenVocab= CssLexer; }

stylesheet
    : (statement | atRule)* EOF                   #StylesheetRule
    ;

statement
    : selectorGroup LBRACE declarationList? RBRACE #StatementRule
    ;

selectorGroup
    : selector (COMMA selector)*                  #SelectorGroupRule
    ;

selector
    : simpleSelector (combinator simpleSelector)* #SelectorRule
    ;

simpleSelector
    : IDENT                                       #IdentSelector
    | HASH IDENT                                  #IdSelector
    | DOT IDENT                                   #ClassSelector
    | STAR                                        #UniversalSelector
    ;

combinator
    : PLUS                                        #AdjacentSiblingCombinator
    | GREATER                                     #ChildCombinator
    | TILDE                                       #GeneralSiblingCombinator
    ;

declarationList
    : declaration (SEMICOLON declaration)* SEMICOLON? #DeclarationListRule
    ;

declaration
    : property COLON value (IMPORTANT)?           #DeclarationRule
    ;

property
    : IDENT                                       #PropertyRule
    ;

value
    : valueItem+                                  #ValueRule
    ;

valueItem
    : IDENT                                       #IdentValue
    | NUMBER                                      #NumberValue
    | PERCENTAGE                                  #PercentageValue
    | DIMENSION                                   #DimensionValue
    | STRING                                      #StringValue
    | HASH                                        #HashValue
    | OPEN_PAREN value CLOSE_PAREN                #ParenValue
    | COMMA                                       #CommaValue
    | STAR                                        #StarValue
    | PLUS                                        #PlusValue
    | MINUS                                       #MinusValue
    ;

atRule
    : AT_RULE (IDENT | STRING)* SEMICOLON         #AtRuleStatement
    ;












//    body {
//      margin: 0;
//      padding: 10px;
//      background-color: #f0f0f0;
//    }
//
//    h1, h2 {
//      color: blue;
//      font-size: 24px;
//    }















//    body {
//      font-family: Arial, sans-serif;
//      background-color: #f4f4f4;
//      margin: 0;
//      padding: 0;
//    }
//
//    header {
//      background-color: #333;
//      color: white;
//      text-align: center;
//      padding: 20px;
//    }
//
//    ul {
//      list-style: none;
//      margin: 0;
//      padding: 0;
//      background-color: #444;
//      display: flex;
//    }
//
//    nav {
//      flex: 1;
//    }
//
//    a {
//      display: block;
//      padding: 10px;
//      color: white;
//      text-decoration: none;
//      text-align: center;
//    }
//
//    nav ul li a:hover {
//      background-color: #666;
//    }
//
//    main {
//      padding: 20px;
//      background-color: white;
//    }
//
//    footer {
//      background-color: #333;
//      color: white;
//      text-align: center;
//      padding: 10px;
//    }
