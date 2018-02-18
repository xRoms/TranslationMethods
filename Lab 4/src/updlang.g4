grammar language;

e1 returns [int val]: t1 e2[t1.val] {val = $e2.val;};
e2[int i] returns [int val]: '+' t1 e2[i + t1.val] {val = $e2.val;}| {val = i;};
t1: f t2[f.val] {val = $t2.val;};
t2[int i] returns [int val]: '*'f t2[i*f.val] {val = $t2.val}| {val = i;};
f returns [int i]: DIGIT {val = Integer.parseInt();}|'('e1')' {val = $e1.val;};

DIGIT: '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9';