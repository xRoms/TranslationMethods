# 1 Разработка грамматики

exp -> var other
other -> type; other
other -> type;
type -> varnames: name
varnames -> name, varnames
varnames -> name
name -> [a-z]name
name -> [a-z]

Нетерминалы | Описание
------------|---------
exp | Строка описания переменных в Pascal
var | Ключевое слово "var"
type | Описание нескольких переменых одного типа
other | Описания остальных переменных 
varnames | Названия переменных одного типа через запятую
name | Имя переменной

