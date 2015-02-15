package p1;

import java.util.Stack;

public class Parser {
	private Lexer lexer = new Lexer();
	private Token currToken = new Token();
	
	public Parser(Lexer lex) {
		lexer = lex;
	}
	
	public void parse() {
		currToken = lexer.nextToken();
	}
	
	Stack<Token> s = new Stack<Token>();
	
}
