grammar Parser;

gramm: title header? members? (nonterm | terminal)*;

title: 'grammar ' NONTERM ';' # mtitle;

header: '@header' CODE # mheader;
members: '@members' CODE # mmembers;

nonterm: NONTERM ':' anyrule ('|' anyrule)*';' # mnonterm;

anyrule: anyrule1*;

anyrule1: (NONTERM | TERMINAL | STRING);

terminal: TERMINAL ':' string ('|' string)*';' # mterminal;

string: STRING*;

STRING: '\'' (~'\'' | '\\\'')* '\'';
CODE: '{' (~[{}]+ CODE?)* '}';
NONTERM: [a-z][a-z0-9]*;
TERMINAL: [A-Z][A-Z0-9]*;
WS: [ \t\n\r]+ -> skip;
