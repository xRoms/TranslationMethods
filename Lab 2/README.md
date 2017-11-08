# Разработка грамматики

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
other | Описания переменных 
type | Описание нескольких переменых одного типа
varnames | Названия переменных одного типа через запятую
name | Имя переменной/типа

**Устраним правое ветвление**

exp -> var other  
other -> type; type'  
type' -> type; type'  
type' -> ε  
type -> varnames: name  
varnames -> namevarnames'  
varnames' -> ,` `namevarnames';  
varnames' -> ε  
name -> [a-z]name'  
name' -> [a'z]name'  
name' -> ε  

Нетерминалы | Описание
------------|---------
exp | Строка описания переменных в Pascal
var | Ключевое слово "var"
other | Описания переменных 
type | Описание нескольких переменых одного типа
type' | Описания остальных переменных 
varnames | Не пустой список переменных одного типа через запятую
varnames'| Названия переменных одного типа через запятую
name | Не пустое имя переменной/типа
name' | Имя переменной/типа

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
name | `l` | `;` `,` `:`
name' | `l` `ε` | `;` `,` `:`
