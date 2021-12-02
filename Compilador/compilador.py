import token
from Lex import *
from tokentype import *

def main():
    #input = "IF+-121212 algo*THEN"
    file = open("./Compilador/code.cim","r")
    input = file.read()

    lexer = Lexer(input)
    token = lexer.getToken()
    cont = 0
    while token.king != TokenType.EOF:
        print("Token Type: {}, Content: {}".format(token.king, token.text))
        token = lexer.getToken()
        cont+=1
    print("numero tokens found: {}".format(cont))

main()