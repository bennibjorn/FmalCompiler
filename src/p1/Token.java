package p1;

public class Token {
	
	enum TokenCode {
		ID,
		ASSIGN,
		SEMICOL,
		INT,
		PLUS,
		MINUS,
		MULT,
		LPAREN,
		RPAREN,
		PRINT,
		END,
		ERROR
	}
	String lexeme;
	TokenCode tCode;
}
