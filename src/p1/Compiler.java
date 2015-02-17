package p1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Compiler {
	public static void main(String[] args) {
		Lexer myLexer = new Lexer(readInput());
		Parser myParser = new Parser(myLexer);
		myParser.parse();
	}
	
	private static String readInput() {
		String input = "";
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
	 
			while((line=br.readLine()) != null) {
				input += line + "\n";
				if(line.compareTo("end") == 0) break;
			}
		} catch(IOException io){
			io.printStackTrace();
			System.exit(0);
		}
		return input;
	}
}
