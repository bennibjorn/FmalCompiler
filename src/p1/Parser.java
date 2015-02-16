package p1;

import java.util.Stack;
import p1.Token.TokenCode;

public class Parser {
	private Lexer lexer = new Lexer();
	private Token currToken = null;
	
	public Parser(Lexer lex) {
		lexer = lex;
	}
	
	public void parse() {
		currToken = lexer.nextToken();
		
		if(currToken.tCode == TokenCode.ERROR) {
			System.out.println("Syntax error!");
		}
	}
	
	Stack<Token> s = new Stack<Token>();
	
}
