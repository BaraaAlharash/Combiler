parser grammar JinjaHtmlParser;

options {
    tokenVocab = JinjaHtmlLexer;
}

// ============================================= HTML Parser ==============================================

htmlDocument
    : scriptletOrSeaWs* XML? scriptletOrSeaWs* DTD? scriptletOrSeaWs*
      ( htmlElements
      | jinja_var
      | jinja_stmt
      | htmlMisc
      | htmlChardata
      )*
      EOF
    ;

scriptletOrSeaWs
    : SCRIPTLET
    | SEA_WS
    ;

htmlElements
    : htmlMisc* htmlElement htmlMisc*
    ;

htmlElement
    : TAG_OPEN TAG_NAME htmlAttribute* tagEnd
        ( htmlContent endTag )?
    | TAG_OPEN TAG_SLASH TAG_NAME tagEnd   // </tag>
    | SCRIPTLET
    | script
    | style
    ;

// نهاية وسم الفتح: يا > أو /> (حسب المود)
tagEnd
    : TAG_CLOSE
    | TAG_SLASH_CLOSE
    | ATTR_END
    | ATTR_SLASH_CLOSE
    ;

// وسم الإغلاق بعد المحتوى
endTag
    : TAG_OPEN TAG_SLASH TAG_NAME (TAG_CLOSE | ATTR_END)
    ;

htmlContent
    : htmlChardata? ((htmlElement | jinja_var | jinja_stmt | CDATA | htmlComment) htmlChardata?)*
    ;

htmlAttribute
    : TAG_NAME (TAG_EQUALS ATTVALUE_VALUE)?
    ;

// بما أننا حذفنا HTML_TEXT بالـ lexer، خليه TEXT فقط
htmlChardata
    : TEXT
    | SEA_WS
    ;

htmlMisc
    : htmlComment
    | SEA_WS
    ;

htmlComment
    : HTML_COMMENT
    | HTML_CONDITIONAL_COMMENT
    ;

script
    : SCRIPT_OPEN (SCRIPT_BODY | SCRIPT_SHORT_BODY)
    ;

style
    : STYLE_OPEN (STYLE_BODY | STYLE_SHORT_BODY)
    ;

// ============================================= Jinja Parser ==============================================

element
    : htmlElement
    | htmlChardata
    | jinja_var
    | jinja_stmt
    | CDATA
    | htmlComment
    ;

jinja_var
    : VAR_OPEN expr VAR_CLOSE
    ;

jinja_stmt
    : if_stmt
    | for_stmt
    | set_stmt
    ;

// ---------------- Statements ----------------

if_stmt
    : STMT_OPEN IF expr STMT_CLOSE
        element*
      (STMT_OPEN ELIF expr STMT_CLOSE element*)*
      (STMT_OPEN ELSE STMT_CLOSE element*)?
      STMT_OPEN ENDIF STMT_CLOSE
    ;

for_stmt
    : STMT_OPEN FOR NAME IN expr STMT_CLOSE
        element*
      STMT_OPEN ENDFOR STMT_CLOSE
    ;

set_stmt
    : STMT_OPEN SET NAME ASSIGN expr STMT_CLOSE
    ;

// ---------------- Expressions ----------------

expr
    : or_expr
    ;

or_expr
    : and_expr (OR and_expr)*
    ;

and_expr
    : not_expr (AND not_expr)*
    ;

not_expr
    : NOT not_expr
    | compare_expr
    ;

compare_expr
    : add_expr ((EQ | NE | LT | GT | LE | GE) add_expr)*
    ;

add_expr
    : mul_expr ((ADD | SUB) mul_expr)*
    ;

mul_expr
    : unary_expr ((MUL | DIV | MOD) unary_expr)*
    ;

unary_expr
    : (ADD | SUB) unary_expr
    | primary
    ;

primary
    : literal
    | variable
    | OPEN_PAREN expr CLOSE_PAREN
    ;

variable
    : NAME access*
    ;

access
    : DOT NAME
    | OPEN_BRACKET expr CLOSE_BRACKET
    ;

literal
    : NUMBER
    | STRING
    | TRUE
    | FALSE
    | NONE
    ;
