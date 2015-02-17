package p1;

//import java.io.IOException;
import java.util.regex.*;
//import java.util.Scanner;

public class Lexer {
	
	private String[] lex;
	private String[] stringPattern;
	private String inputstring;
	private Pattern pattern[];
	private int check;
	
	public Lexer() {
		System.out.println("Put a fucking string or a file into me you fuck");
		inputstring = null;
		nextToken();
	}
	
	public Lexer(String input) {
		inputstring = input;
		System.out.println("inside lexer constructor"); //debug
		lex = null;
		check = 0;
		
		// String patterns for splitting
		stringPattern = new String[11];
		stringPattern[0] = "[0-9]+"; //INT
		stringPattern[1] = "[A-Za-z]+"; //ID
		stringPattern[2] = "end"; //END
		stringPattern[3] = "print"; //PRINT
		stringPattern[4] = "\\+"; //PLUS
		stringPattern[5] = "\\-"; //MINUS
		stringPattern[6] = "\\*"; //MULT
		stringPattern[7] = "\\)"; //LPAREN
		stringPattern[8] = "\\("; //RPAREN
		stringPattern[9] = "\\;"; //SEMICOL
		stringPattern[10] = "\\="; //ASSIGN
		
		// Compiled patterns for searching
		pattern = new Pattern[11];
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
		pattern[10] = Pattern.compile("\\="); //ASSIGN
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
		
		//Matcher next = null;
		
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
		lex = input.split("\\s"); //first split on whitespaces
		if (patternChecker()) {
			System.out.println("PatternChecker is done and returns true");
		}
		else {
			System.out.println("Error in patternChecker, it returned false");
		}
		
		//if lookingAt = true, checka á matches líka, ef það er true, return með næsta staki í lex
		//If lookingAt = true, en matches != true, splitta með því patterni
		//debug
		System.out.println("Lex array: \n");
		for (int i = 0; i < lex.length; i++) {
			System.out.println(i + ": " + lex[i]);
		}
	}
	/*
	 * patternChecker checks if the element given matches only one pattern
	 * in the array of patterns. If it does, it returns true and the while loop
	 * checks the next one. If it returns false, the loop above will try to find
	 * a pattern within the element and split it again until only one pattern remains.
	 */
	private boolean patternChecker() {
		//Pattern p = Pattern.compile(lex[check]); //set the current pattern to the element given
		Matcher m = null; 
		
		for (int i = 0; i < pattern.length; i++) { 
			//m = p.matcher(patterns[i]); //sets the matcher pattern to number 'i' on the list of patterns
			m = pattern[i].matcher(lex[check]);
			//p.matches(pattern[i], elem);
			if (m.lookingAt()) {
				if (m.matches()) {
					++check;
					patternChecker(); //recursive call until everything returns true
					return true;
				}
				else { //split on lex[check] with given pattern
					lex[check].split(stringPattern[i]);
					//lex[check] = (String[])lex[check].split(""); //debug purposes
					//TODO:
					/*
					 * Nota ArrayList í stað String[] þar sem hægt er að stækka það
					 * eftir þörfum sem er nauðsynlegt hér.
					 * Hér þarf að stækka arrayið um einn, taka svo bæði split elements og setja þau
					 * í nýja og það sem var splittað frá. Þannig ætti það að stækka!
					 */
				}
			}
		}
		
		return false;
	}
}
