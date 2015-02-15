package p1;

public class Token {

	public enum TokenCode {
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
	
	public String lexeme;
	public TokenCode tCode;
}
