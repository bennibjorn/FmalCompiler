package p1;

import p1.Token.TokenCode;
import java.lang.Character;
import java.util.ArrayList;

public class Lexer {
	private static final TokenCode ID = Token.TokenCode.ID;
	private static final TokenCode INT = Token.TokenCode.INT;
	private static final TokenCode LPAREN = Token.TokenCode.LPAREN;
	private static final TokenCode RPAREN = Token.TokenCode.RPAREN;
	private static final TokenCode PLUS = Token.TokenCode.PLUS;
	private static final TokenCode MINUS = Token.TokenCode.MINUS;
	private static final TokenCode MULT = Token.TokenCode.MULT;
	private static final TokenCode SEMICOL = Token.TokenCode.SEMICOL;
	private static final TokenCode ASSIGN = Token.TokenCode.ASSIGN;
	private static final TokenCode PRINT = Token.TokenCode.PRINT;
	private static final TokenCode END = Token.TokenCode.END;
	private static final TokenCode ERROR = null;
	
	public String inputString;
	private int inputPos;
	private ArrayList<Character> lex;
	
	public Lexer(String in) {
		inputPos = 0;
		inputString = in;
		lex = new ArrayList<Character>();
	}
	
	/*
	 * checks the current position 
	 */
	public Token nextToken() { // switch á TokenCode nextToken
		if (Character.isSpaceChar(inputString.charAt(inputPos)) || (inputString.charAt(inputPos) == '\n')) { // checks for whitespace and newline
			++inputPos;
			return nextToken();
		}
		if (Character.isLetter(inputString.charAt(inputPos))) { // checks for letters
			return checkPrintEndID();
		}
		else if (Character.isDigit(inputString.charAt(inputPos))) { // checks for digits
			return checkDigit();
		}
		else {
			return checkOps(); // checks for operators
		}
	}
	
	//checks if a sequence of letters in the inputString
	//are print, end or an ID
	private Token checkPrintEndID() {
		Token next = null;
		if (inputString.charAt(inputPos) == 'p' &&
			inputString.charAt(inputPos+1) == 'r' &&
			inputString.charAt(inputPos+2) == 'i' &&
			inputString.charAt(inputPos+3) == 'n' &&
			inputString.charAt(inputPos+4) == 't') {
			next = new Token();
			next.lexeme = "print";
			next.tCode = PRINT;
			inputPos += 5;
			return next;
		}
		else if (inputString.charAt(inputPos) == 'e' &&
				inputString.charAt(inputPos+1) == 'n' &&
				inputString.charAt(inputPos+2) == 'd') {
				next = new Token();
				next.lexeme = "end";
				next.tCode = END;
				inputPos += 3;
				return next;
		}
		else {
			while (Character.isLetter(inputString.charAt(inputPos))) {
				lex.add(inputString.charAt(inputPos));
				++inputPos;
			}
			next = new Token();
			next.tCode = ID;
			next.lexeme = makeString(lex);
			//Empty lex for future uses
			lex.removeAll(lex);
			
			return next;
		}
	}

	private Token checkDigit() {
		Token digit = null;
		while (Character.isDigit(inputString.charAt(inputPos))) {
			lex.add(inputString.charAt(inputPos));
			++inputPos;
		}
		digit = new Token();
		digit.lexeme = makeString(lex);
		digit.lexeme.split("[,\\[\\]\\s]");
		digit.tCode = INT;
		//Empty lex for future uses
		lex.removeAll(lex);
		
		return digit;
	}
	// Finds the appropriate operator and creates a token
	// and returns it.
	private Token checkOps() {
		TokenCode nextToken;
		Token op = null;
		switch(inputString.charAt(inputPos)) {
			case '(':
				nextToken = LPAREN;
				break;
			case ')':
				nextToken = RPAREN;
				break;
			case '+':
				nextToken = PLUS;
				break;
			case '-':
				nextToken = MINUS;
				break;
			case '*':
				nextToken = MULT;
				break;
			case ';':
				nextToken = SEMICOL;
				break;
			case '=':
				nextToken = ASSIGN;
				break;
			default:
				nextToken = ERROR;
				break;
		}
		lex.add(inputString.charAt(inputPos));
		op = new Token();
		op.lexeme = makeString(lex);
		op.tCode = nextToken;
		//Empty lex for future uses
		lex.removeAll(lex);
		
		++inputPos;
		return op;
	} 
	// Builds a string from the character ArrayList
	private String makeString(ArrayList<Character> list) {
		// gotten from http://stackoverflow.com/questions/6324826/converting-arraylist-of-characters-to-a-string
		StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}
}
