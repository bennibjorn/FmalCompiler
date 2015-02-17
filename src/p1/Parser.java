package p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import p1.Token.TokenCode;

public class Parser {
	private Lexer lexer = null;
	private Token currToken = null;
	private Token lastToken = null;								// The previous token
	private Stack<Token> valStack = new Stack<Token>();
	private Stack<Token> opStack = new Stack<Token>();
	private Map<String, Integer> valMap = new HashMap<String, Integer>(); 	// Map for <variable, value>

	public Parser(Lexer lex) {
		lexer = lex;
	}
	
	public void parse() {
		while(true) {
			lastToken = currToken;
			currToken = lexer.nextToken();
			
			if(currToken.tCode == TokenCode.ERROR) {
				System.out.println("Syntax error!");
				System.exit(0);
			} else if(currToken.tCode == TokenCode.END) {
				return;
			} else if(currToken.tCode == TokenCode.ID) {
				// Push variable
			} else if(currToken.tCode == TokenCode.ASSIGN) {
				// Assign a number to a variable
			} else if(currToken.tCode == TokenCode.SEMICOL) {
				// Ignore?
			} else if(currToken.tCode == TokenCode.INT) {
				// Push value
				//int val = getVal(currToken);
				valStack.push(currToken);
			} else if(currToken.tCode == TokenCode.PLUS) {
				
			} else if(currToken.tCode == TokenCode.MINUS) {
				
			} else if(currToken.tCode == TokenCode.MULT) {
				
			} else if(currToken.tCode == TokenCode.LPAREN) {
								
			} else if(currToken.tCode == TokenCode.RPAREN) {
				
			} else if(currToken.tCode == TokenCode.PRINT) {
				// Print variable
			} else if(currToken.tCode == TokenCode.END) {
				
			} else if(currToken.tCode == TokenCode.ERROR) {
				
			}
		}		
	}
	
	private int getVal(Token t) {
		if(t.tCode == TokenCode.INT) {
			return Integer.parseInt(t.lexeme);
		} else if(t.tCode == TokenCode.ID) {
			// Lookup value, return 0 if no value and print error
			Integer val = valMap.get(t.lexeme);
			if(val == null) {
				val = 0;
				System.out.println("Error in getVal()");
			}
			return val.intValue();
		}
		System.out.println("Error in getVal()");
		return 0;
	}
	
	/*
	 	Statements -> Statement ; Statements | end
		Statement -> id = Expr | print id
		Expr- > Term | Term + Expr | Term – Expr
		Term -> Factor | Factor * Term
		Factor -> int | id | ( Expr )
	 */
	
	// Statements -> &Statement ; &Statements | end
	private void statements() {
		//if end
			// exit
		// else
			// statement
			// ignore ; for now
			// statements, recursive
	}
	
	// Statement -> id = &Expr | print id
	private void statement() {
		// if print
			// push print
			// nextToken
			// if id
				// push id
				// nextToken
			// else
				// error
		// else if, id
			// push id
			// nextToken
			// if =
				// nextToken
				// expr
				// push assign
			// else
				// error
		// else
			// error
	}
	
	// Expr- > &Term | &Term + &Expr | &Term – &Expr
	private void expr() {
		// term
		// if +
			// nextToken
			// expr
			// push +
		// else if -
			// nextToken
			// expr
			// push -
		// else
			// error
	}
	
	// Term -> &Factor | &Factor * &Term
	private void term() {
		// factor
		// nextToken
		// if *
			// nextToken
			// term
			// push *
	}
	
	// Factor -> int | id | ( &Expr )
	private void factor() {
		// if int
			// push int
			// nextToken
		// if else id
			// push id
			// nextToken
		// if else (
			// nextToken
			// expr
			// if )
				// nextToken
			// else
				// error
		// else
			// error
	}
	
	private void error() {
		System.out.println("Syntax error!");
		System.exit(0);
	}
}
