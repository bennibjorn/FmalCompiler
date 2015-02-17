package p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import p1.Token.TokenCode;

public class Interpreter {
	// Global variables
	private Map<String, Integer> valMap = new HashMap<String, Integer>(); 	// Map for <variable, value>
	private Stack<String> tStack = new Stack<String>();
	private String[] commands;
	private int commandPos;
	
	public Interpreter() {
		commands = null;
		commandPos = 0;
		read();
	}
	public void read() {
		String examplestring = 
				"PUSH var" + "\n" +
				"PUSH 3" + "\n" +
				"ASSIGN" + "\n" +
				"PUSH b" + "\n" +
				"PUSH 4" + "\n" +
				"PUSH 7" + "\n" +
				"PUSH var" + "\n" +
				"SUB" + "\n" +
				"MULT" + "\n" +
				"ASSIGN" + "\n" +
				"PUSH b" + "\n" +
				"PRINT";
		String[] splitString = examplestring.split("\\s");
		evaluate();
	}
	private void evaluate() {
		// follow the commands given
		switch (commands[commandPos]){
		case ("PUSH"):
			push(commands[commandPos+1]);
			commandPos += 2;
			break;
		case ("ADD"):
			add();
			++commandPos;
			break;
		case ("SUB"):
			//sub();
			++commandPos;
			break;
		//case ("")
		}
	}
	
	private void push(String toPush) {
		tStack.push(toPush);
	}
	private void add() {
		
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
}
