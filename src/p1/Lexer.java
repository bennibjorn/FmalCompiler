package p1;

import java.util.regex.*;

public class Lexer {
	public Token nextToken() {
		Token token = null;
		

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
		
		
		
		return token;
	}
	private void read() {
		
	}
}
