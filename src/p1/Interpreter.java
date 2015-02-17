package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreter {
	// Global variables
	private Map<String, Integer> valMap = new HashMap<String, Integer>(); 	// Map for <variable, value>
	private Stack<String> tStack = new Stack<String>();
	private String[] commands;
	private int commandPos;
	
	public static void main(String[] args) {
		Interpreter in = new Interpreter();
		in.read();
		System.exit(0);
	}
	
	public Interpreter() {
		commands = null;
		commandPos = 0;
	}
	
	private void read() {
		String input = "";
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
	 
			while((line=br.readLine()) != null) {
				input += line + "\n";
			}
		} catch(IOException io){
			io.printStackTrace();
			System.exit(0);
		}
		commands = input.split("[\\\n\\s]");
		evaluate();
	}
	private void evaluate() {
		// follow the commands given
		while (commandPos < commands.length) {
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
				sub();
				++commandPos;
				break;
			case ("MULT"):
				mult();
				++commandPos;
				break;
			case ("ASSIGN"):
				assign();
				++commandPos;
				break;
			case ("PRINT"):
				print();
				++commandPos;
				break;
			default:
				System.out.println("Error");
				System.exit(0);
				break;
			}
		}
	}
	private void push(String toPush) {
		tStack.push(toPush);
	}
	private void print() {
		if (isINT(tStack.peek())) {
			System.out.println(tStack.peek()); //.toString ?
		}
		else { // must get value of variable from map
			System.out.println(Integer.toString(valMap.get(tStack.peek())));
		}
	}
	private void assign() {
		int value = Integer.parseInt(tStack.pop());
		String variable = tStack.pop();
		valMap.put(variable, value);
	}
	private void mult() {
		String value1 = tStack.pop();
		String value2 = tStack.pop();
		tStack.push(checkType(value1, value2, "MULT"));
	}
	private void sub() {
		String value1 = tStack.pop();
		String value2 = tStack.pop();
		tStack.push(checkType(value1, value2, "SUB"));
	}
	private void add() {
		String value1 = tStack.pop();
		String value2 = tStack.pop();
		tStack.push(checkType(value1, value2, "ADD"));
	}
	private String checkType(String value1, String value2, String op) {
		
		int val1 = 0;
		int val2 = 0;
		
		if (isINT(value1) && isINT(value2)) { //both are integers
			val1 = Integer.parseInt(value1);
			val2 = Integer.parseInt(value2);
		}
		else if (isINT(value1) && !isINT(value2)) { //value1 is an integer, value2 is a variable
			val1 = Integer.parseInt(value1);
			val2 = valMap.get(value2);
		}
		else if (!isINT(value1) && isINT(value2)) { //value2 is an integer, value1 is a variable
			val1 = Integer.parseInt(value2);
			val2 = valMap.get(value1);
		}
		else if (!isINT(value1) && !isINT(value2)) { // both are variables
			val1 = valMap.get(value1);
			val2 = valMap.get(value2);
		}
		
		if (val1 == 0 && val2 == 0) {
			System.out.println("both values are 0, error in checkType");
		}
		
		switch (op) {
			case "MULT":
				return Integer.toString(val1 * val2);
			case "ADD":
				return Integer.toString(val1 + val2);
			case "SUB":
				return Integer.toString(val2 - val1);
		}
		return null; // should not reach this point
	}
	private boolean isINT(String test)  
	{  
	  try  
	  {  
	    @SuppressWarnings("unused")
		int i = Integer.parseInt(test);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;
	  }  
	  return true;
	}
}
