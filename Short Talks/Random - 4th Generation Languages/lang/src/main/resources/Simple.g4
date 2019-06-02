grammar Simple;
@header{
package prz.lang;
}
atom : NUMBER | ID ;                // match identifier or number
expression  :     // match atom and operator and expression
    atom
    | expression OP atom ;

NUMBER : [1-9][0-9]* ;              // match numbers
ID : [a-z]+ ;                       // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ;           // skip spaces, tabs, newlines
OP : ('+'|'-'|'*'|'/')  ;           // match +-/*