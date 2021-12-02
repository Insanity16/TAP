# definir todos los tokens enumerarlos 
import enum
class TokenType(enum.Enum):
    EOF = -1
    # public static para java 
    NEWLINE = 0
    NUMBER = 1
    IDENT = 2
    STRING = 3
    #KEYWORDS
    LABEL = 101
    GOTO = 102
    PRINT = 103
    INPUT = 104
    LET = 105
    IF = 106
    THEN = 107
    ENDIF = 108
    WHILE = 109
    REPEAT = 110
    ENDWHILE = 111
    
    declara = 112
    traduce = 113
    imprime = 114
    borra = 115

    como = 116

    entero = 117
    flotante = 118
    
   

    '.-' = 130
    '-...' = 131
    '-.-.' = 132
    '-..' = 133
    '.' = 134
    '..-.' = 135
    '--.' = 136
    '....' = 137
    '..' = 138
    '.---' = 139
    '-.-' = 140
    '.-..' = 141
    '--' = 142
    '-.' = 143
    '---' = 144
    '.--.' = 145
    '--.-' = 146
    '.-.' = 147
    '...' = 148
    '-' = 149
    '..-' = 150
    '...-' = 151
    '.--' = 152
    '-..-' = 153
    '-.--' = 154
    '--..' = 155

    '..-.-' = 160
    '..--..' = 161
    '--...-' = 162
    '-.--.' = 163
    '-.--.-' = 164
    '-.-.-.' = 165
  

    #OPERADORES
    EQ = 201
    PLUS = 202
    MINUS = 203
    ASTERISK = 204
    SLASH = 205
    EQEQ = 206
    NOTEQ = 207
    LT = 208
    LTEQ = 209
    GT = 210
    GTEQ = 211
    suma = 212
    resta = 213
    multiplica = 214
    divide = 215
