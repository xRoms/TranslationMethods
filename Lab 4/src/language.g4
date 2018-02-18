grammar language;

e1: t1 e2;
e2: '+'t1 e2|;
t1: f t2;
t2: '*'f t2|;
f: DIGIT|'('e1')';

DIGIT: '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9';