grammar Hello;
main_rule: definevars body;

definevars: VAR EL (linevars)+;

linevars: NAME {System.out.print("int " + $NAME.text);}
          (COM WS NAME {System.out.print(", " + $NAME.text);})*
          {System.out.println(";");} WS? CLN WS? INTEGER SMC EL;

namevar returns[String name]: NAME {$name = $NAME.text;};

body: BEGIN {System.out.print("int main() {\n");} EL (statement)* END {System.out.print("}");};

statement: assignment | print;

assignment: NAME WS? SET WS? math SMC EL {System.out.println($NAME.text + " = " + $math.out + ";");};

math returns[String out]: ((NUMBER {$out = $NUMBER.text;}) | (NAME {$out = $NAME.text;}))
                          (WS OPERATION WS {$out = $out.concat(" " + $OPERATION.text + " ");} ((NUMBER {$out = $out.concat($NUMBER.text);}) | (NAME{$out = $out.concat($NAME.text);})))*;

print: WRITE WS? OBR inwrite
          {System.out.print("printf(\"");
          String temp = $inwrite.inside + ",";
          String temp2 = "";
          String temporal;
          String part2 = "";
          int last = -1;
          int new1 = -1;
          while (temp.indexOf((int)',', last + 1) != -1) {
                new1 = temp.indexOf((int)',', last + 1);
                temporal = temp.substring(last + 1, new1);
                temporal = temporal.trim();
                if (temporal.charAt(0) == '$') {
                    part2 = part2.concat(", " + temporal.substring(1, temporal.length()));
                    temp2 = temp2.concat("%d");
                }
                else {
                    temp2 = temp2.concat(temporal.substring(1, temporal.length() - 1));
                }
                last = new1;
          }
          System.out.println(temp2 + "\"," + part2.substring(1, part2.length()) + ");");
          }
          CBR SMC EL;

inwrite returns[String inside]:
        ((math {$inside = "$" + $math.out;}) | (TEXT {$inside = $TEXT.text;}))
        (WS? COM WS? ((math {$inside = $inside.concat(",$" + $math.out);}) | (( TEXT {$inside = $inside.concat("," + $TEXT.text);} ))))*;






WS: ' ';
COM: ',';
EL: '\r'? '\n';
VAR: 'var';
BEGIN: 'begin';
END: 'end.';
INTEGER: 'integer';
SMC: ';';
CLN: ':';
WRITE: 'write';
OBR: '(';
CBR: ')';
SET: ':=';
AP: '\'';
OPERATION: '+'|'-'|'*'|'/';
NUMBER: '0'|(('1'..'9')('0'..'9')*);
NAME: ('a'..'z')+;
TEXT: '\''('a'..'z'|'A'..'Z'|'0'..'9'|' '|'.')*'\'';




