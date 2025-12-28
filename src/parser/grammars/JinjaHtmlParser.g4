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
      EOF                                       #HtmlDocumentRule
    ;

scriptletOrSeaWs
    : SCRIPTLET                                #ScriptletRule
    | SEA_WS                                   #SeaWsRule
    ;

htmlElements
    : htmlMisc* htmlElement htmlMisc*          #HtmlElementsRule
    ;

htmlElement
    : TAG_OPEN TAG_NAME htmlAttribute* tagEnd
        ( htmlContent endTag )?                #HtmlOpenElement
    | TAG_OPEN TAG_SLASH TAG_NAME tagEnd       #HtmlCloseElement
    | SCRIPTLET                                #HtmlScriptletElement
    | script                                   #HtmlScriptElement
    | style                                    #HtmlStyleElement
    ;

tagEnd
    : TAG_CLOSE                                #TagClose
    | TAG_SLASH_CLOSE                          #TagSlashClose
    | ATTR_END                                 #AttrEnd
    | ATTR_SLASH_CLOSE                         #AttrSlashClose
    ;

endTag
    : TAG_OPEN TAG_SLASH TAG_NAME (TAG_CLOSE | ATTR_END) #EndTagRule
    ;

htmlContent
    : htmlChardata? ((htmlElement | jinja_var | jinja_stmt | CDATA | htmlComment) htmlChardata?)* #HtmlContentRule
    ;

htmlAttribute
    : TAG_NAME (TAG_EQUALS ATTVALUE_VALUE)?    #HtmlAttributeRule
    ;

htmlChardata
    : TEXT                                     #TextData
    | SEA_WS                                   #WhitespaceData
    ;

htmlMisc
    : htmlComment                              #HtmlCommentMisc
    | SEA_WS                                   #HtmlWhitespaceMisc
    ;

htmlComment
    : HTML_COMMENT                             #HtmlCommentRule
    | HTML_CONDITIONAL_COMMENT                 #HtmlConditionalCommentRule
    ;

script
    : SCRIPT_OPEN (SCRIPT_BODY | SCRIPT_SHORT_BODY) #ScriptRule
    ;

style
    : STYLE_OPEN (STYLE_BODY | STYLE_SHORT_BODY)    #StyleRule
    ;

// ============================================= Jinja Parser ==============================================

element
    : htmlElement                              #HtmlElementNode
    | htmlChardata                             #HtmlCharDataNode
    | jinja_var                                #JinjaVarNode
    | jinja_stmt                               #JinjaStmtNode
    | CDATA                                    #CDataNode
    | htmlComment                              #HtmlCommentNode
    ;

jinja_var
    : VAR_OPEN expr VAR_CLOSE                  #JinjaVarRule
    ;

jinja_stmt
    : if_stmt                                  #IfStmtNode
    | for_stmt                                 #ForStmtNode
    | set_stmt                                 #SetStmtNode
    ;

// ---------------- Statements ----------------

if_stmt
    : STMT_OPEN IF expr STMT_CLOSE
        element*
      (STMT_OPEN ELIF expr STMT_CLOSE element*)*
      (STMT_OPEN ELSE STMT_CLOSE element*)?
      STMT_OPEN ENDIF STMT_CLOSE               #IfStatementRule
    ;

for_stmt
    : STMT_OPEN FOR NAME IN expr STMT_CLOSE
        element*
      STMT_OPEN ENDFOR STMT_CLOSE              #ForStatementRule
    ;

set_stmt
    : STMT_OPEN SET NAME ASSIGN expr STMT_CLOSE #SetStatementRule
    ;

// ---------------- Expressions ----------------

expr
    : or_expr                                  #ExprRule
    ;

or_expr
    : and_expr (OR and_expr)*                  #OrExprRule
    ;

and_expr
    : not_expr (AND not_expr)*                 #AndExprRule
    ;

not_expr
    : NOT not_expr                             #NotExprRule
    | compare_expr                             #CompareExprNode
    ;

compare_expr
    : add_expr ((EQ | NE | LT | GT | LE | GE) add_expr)* #CompareExprRule
    ;

add_expr
    : mul_expr ((ADD | SUB) mul_expr)*         #AddExprRule
    ;

mul_expr
    : unary_expr ((MUL | DIV | MOD) unary_expr)* #MulExprRule
    ;

unary_expr
    : (ADD | SUB) unary_expr                   #UnaryExprRule
    | primary                                  #PrimaryExprNode
    ;

primary
    : literal                                  #LiteralPrimary
    | variable                                 #VariablePrimary
    | OPEN_PAREN expr CLOSE_PAREN              #ParenPrimary
    ;

variable
    : NAME access*                             #VariableRule
    ;

access
    : DOT NAME                                 #DotAccess
    | OPEN_BRACKET expr CLOSE_BRACKET          #BracketAccess
    ;

literal
    : NUMBER                                   #NumberLiteral
    | STRING                                   #StringLiteral
    | TRUE                                     #TrueLiteral
    | FALSE                                    #FalseLiteral
    | NONE                                     #NoneLiteral
    ;



//    <!DOCTYPE html>
//    <html lang="ar">
//      <head>
//        <title>{{ title }}</title>
//      </head>
//
//      <body>
//        <h1>Hello {{ user.name }}</h1>
//
//        {% if user %}
//          <p>Welcome back!</p>
//        {% else %}
//          <p>Please log in</p>
//        {% endif %}
//
//        <ul>
//          {% for item in items %}
//            <li>{{ item }}</li>
//          {% endfor %}
//        </ul>
//      </body>
//    </html>