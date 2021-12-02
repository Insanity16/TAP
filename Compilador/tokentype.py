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
    
    ZERO = 120
    ONE = 121
    TWO = 122
    THREE = 123
    FOUR = 124
    FIVE = 125
    SIX = 126
    SEVEN = 127
    EIGHT = 128
    NINE = 129

    A = 130
    B = 131
    C = 132
    D = 133
    E = 134
    F = 135
    G = 136
    H = 137
    I = 138
    J = 139
    K = 140
    L = 141
    M = 142
    N = 143
    O = 144
    P = 145
    Q = 146
    R = 147
    S = 148
    T = 149
    U = 150
    V = 151
    W = 152
    X = 153
    Y = 154
    Z = 155

    GATO = 160
    INTEROGANTE = 161
    ESCAMACION = 162
    PARENTESISIZQ = 163
    PARENTESISDER = 164
    DOSPUNTOS = 165
  

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
