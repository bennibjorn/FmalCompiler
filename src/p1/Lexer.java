package p1;

import java.io.IOException;
import java.util.regex.*;
import java.util.Scanner;

public class Lexer {
	
	private String[] lex;
	
	public Lexer(String input) {
		nextToken(input);
	}
	
	public Token nextToken(String input) {
		Token token = null;
		
		//Extract lexemes from the input and produce the corresponding token
			//attempts to find a substring that matches a given pattern 
		//Return the lexemes and tokens to the caller, i.e. parser
		
		
		
		return token;
	}
	
	
	private String read() {
		Scanner scan = null;
		String input = scan.nextLine();
		
		regexThings(input);
		
		return input;
	}
	private Token regexThings(String input) {
		// Regex define things
		String INTstring = "[0-9]+";
		String IDstring = "[A-Za-z]+";
		String ENDstring = "end";
		String PRINTstring = "print";
		String PLUSstring = "+";
		String MINUSstring = "-";
		String MULTstring = "*";
		String LPARENstring = "{";
		String RPARENstring = "}";
		//String ASSIGNstring = "=";
		String SEMICOLstring = ";";
		
		// Regex Patterns
		Pattern INT = Pattern.compile(INTstring);
		Pattern ID = Pattern.compile(IDstring);
		Pattern END = Pattern.compile(ENDstring);
		Pattern PRINT = Pattern.compile(PRINTstring);
		Pattern PLUS = Pattern.compile(PLUSstring);
		Pattern MINUS = Pattern.compile(MINUSstring);
		Pattern MULT = Pattern.compile(MULTstring);
		Pattern LPAREN = Pattern.compile(LPARENstring);
		Pattern RPAREN = Pattern.compile(RPARENstring);
		Pattern SEMICOL = Pattern.compile(SEMICOLstring);
		
		Matcher next = null;
		
		lex = input.split(" "); //first split on spaces
		// for each element in lex array after whitespace split
		// check with switch if matcher.find() finds any of the Patterns defined
		// and split on that element if found
		
		Token asdf = null;
		return asdf;
	}
}
