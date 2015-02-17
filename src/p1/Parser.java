package p1;

import java.util.ArrayList;
import java.util.List;

import p1.Token.TokenCode;

public class Parser {
	private Lexer lexer = null;
	private Token nextToken = null;
	private List<Token> list = new ArrayList<Token>();
	
	public Parser(Lexer lex) {
		lexer = lex;
	}
	
	public void parse() {
		getNextToken();
		statements();
	}
	
	private void getNextToken() {
		nextToken = lexer.nextToken();
		if(nextToken.tCode == TokenCode.SEMICOL) getNextToken();	// Ignoring ; for now
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
		if(nextToken.tCode == TokenCode.END) {
			System.out.println("Found end");
			return;
		} else {
			statement();
			// Took out ;
			statements();
		}
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
		if(nextToken.tCode == TokenCode.PRINT) {
			list.add(nextToken);
			System.out.println("PRINT");
			getNextToken();
			if(nextToken.tCode == TokenCode.ID) {
				list.add(nextToken);
				System.out.println("PUSH " + nextToken.lexeme);
				getNextToken();
			} else {
				error();
			}
		} else if(nextToken.tCode == TokenCode.ID) {
			list.add(nextToken);
			System.out.println("PUSH " + nextToken.lexeme);
			getNextToken();
			if(nextToken.tCode == TokenCode.ASSIGN) {
				Token assign = nextToken;
				getNextToken();
				expr();
				list.add(assign);
				System.out.println("ASSIGN");
			} else {
				error();
			}
		} else {
			error();
		}
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
		term();
		if(nextToken.tCode == TokenCode.PLUS) {
			Token plus = nextToken;
			getNextToken();
			expr();
			list.add(plus);
			System.out.println("ADD");
		} else if(nextToken.tCode == TokenCode.MINUS) {
			Token minus = nextToken;
			getNextToken();
			expr();
			list.add(minus);
			System.out.println("SUB");
		} 
	}
	
	// Term -> &Factor | &Factor * &Term
	private void term() {
		// factor
		// nextToken
		// if *
			// nextToken
			// term
			// push *
		factor();
		getNextToken();
		if(nextToken.tCode == TokenCode.MULT) {
			Token mult = nextToken;
			getNextToken();
			term();
			list.add(mult);
			System.out.println("MULT");
		}
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
		if(nextToken.tCode == TokenCode.INT) {
			list.add(nextToken);
			System.out.println("PUSH " + nextToken.lexeme);
			getNextToken();
		} else if(nextToken.tCode == TokenCode.ID) {
			list.add(nextToken);
			System.out.println("PUSH " + nextToken.lexeme);
			getNextToken();
		} else if(nextToken.tCode == TokenCode.LPAREN) {
			getNextToken();
			expr();
			if(nextToken.tCode == TokenCode.RPAREN) {
				getNextToken();
			} else {
				error();
			}
		} else {
			error();
		}
	}
	
	private void error() {
		System.out.println("Syntax error!");
		System.exit(0);
	}
}
