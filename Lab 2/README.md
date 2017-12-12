# Разработка грамматики

`exp -> var other`  
`other -> type; other`  
`other -> type;`  
`type -> varnames: name`  
`varnames -> name, varnames`  
`varnames -> name`  

Нетерминалы | Описание
------------|---------
exp | Строка описания переменных в Pascal
var | Ключевое слово "var"
other | Описания переменных 
type | Описание нескольких переменых одного типа
varnames | Названия переменных одного типа через запятую

**Устраним правое ветвление**

`exp -> var other`  
`other -> type; type'`  
`type' -> type; type'`  
`type' -> ε`  
`type -> varnames: name`  
`varnames -> namevarnames'`  
`varnames' -> , namevarnames';`  
`varnames' -> ε`  

Нетерминалы | Описание
------------|---------
exp | Строка описания переменных в Pascal
var | Ключевое слово "var"
other | Описания переменных 
type | Описание нескольких переменых одного типа
type' | Описания остальных переменных 
varnames | Не пустой список переменных одного типа через запятую
varnames'| Названия переменных одного типа через запятую

# Множества First Follow

*l - letter* 

Нетерминал | First | Follow
-----------|-------|--------
exp | `v` | `$`
var | `v` | `l`
other| `l` | `$`
type| `l` | `;`
type'| `l` `ε` | `$` `l`
varnames | `l` | `:`
varnames' | `,` `ε` | `,` `:`
