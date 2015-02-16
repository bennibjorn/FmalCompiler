package p1;

//import java.io.IOException;
import java.util.regex.*;
//import java.util.Scanner;

public class Lexer {
	
	private String[] lex;
	private String[] patterns;
	private String inputstring;
	private Pattern pattern[];
	
	public Lexer() {
		System.out.println("Put a fucking string or a file into me you fuck");
		inputstring = null;
	}
	
	public Lexer(String input) {
		inputstring = input;
		System.out.println("inside lexer constructor"); //debug
		lex = null;
		
		// String patterns for splitting
		patterns = new String[10];
		patterns[0] = "[0-9]+"; //INT
		patterns[1] = "[A-Za-z]+"; //ID
		patterns[2] = "end"; //END
		patterns[3] = "print"; //PRINT
		patterns[4] = "\\+"; //PLUS
		patterns[5] = "\\-"; //MINUS
		patterns[6] = "\\*"; //MULT
		patterns[7] = "\\)"; //LPAREN
		patterns[8] = "\\("; //RPAREN
		patterns[9] = "\\;"; //SEMICOL
		
		// Compiled patterns for searching
		pattern = new Pattern[10];
		pattern[0] = Pattern.compile("[0-9]+"); //INT
		pattern[1] = Pattern.compile("[A-Za-z]+"); //ID
		pattern[2] = Pattern.compile("end"); //END
		pattern[3] = Pattern.compile("print"); //PRINT
		pattern[4] = Pattern.compile("\\+"); //PLUS
		pattern[5] = Pattern.compile("\\-"); //MINUS
		pattern[6] = Pattern.compile("\\*"); //MULT
		pattern[7] = Pattern.compile("\\)"); //LPAREN
		pattern[8] = Pattern.compile("\\("); //RPAREN
		pattern[9] = Pattern.compile("\\;"); //SEMICOL
		
		read();
		}
	
	public Token nextToken() {
		Token token = null;
		
		//Extract lexemes from the input and produce the corresponding token
			//attempts to find a substring that matches a given pattern 
		//Return the lexemes and tokens to the caller, i.e. parser

		return token;
	}
	
	
	private void read() {
		//Scanner scan = null;
		//String input = scan.nextLine();
		System.out.println("inside lexer->read"); //debug

		regexThings(inputstring);
		
	}
	private void regexThings(String input) {
		
		Matcher next = null;
		
		/*
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
		*/
		//Pattern p = null;
		lex = input.split(" "); //first split on spaces
		// for each element in lex array after whitespace split
		// check with switch if matcher.find() finds any of the Patterns defined
		// and split on that element if found
		
		for (int i = 0; i < lex.length; i++) {
			for (int u = 0; u < pattern.length; u++) {
				next = pattern[u].matcher(lex[i]);
				if (next.lookingAt()) {
					lex[i].split(patterns[u]);
					System.out.println(lex[i] + " splits on: " + patterns[u]);
				}
			}
		}
		
		//debug
		System.out.println("Lex array: \n");
		for (int i = 0; i < lex.length; i++) {
			System.out.println(i + ": " + lex[i]);
		}
	}
}
