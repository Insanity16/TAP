# la clase token guarda el tipo del token y el texto original



from tokentype import *
class Token:
    def __init__(self, tokenText, tokenKing):
        self.text=tokenText
        self.king=tokenKing

    @staticmethod
    def checkIfKeyword(tokentext):
        for king in TokenType:
            if king.name == tokentext and king.value >= 100 and king.value <= 200:
                return king
        return None