package p1;

public class Compiler {
	Lexer myLexer = new Lexer();
	Parser myParser = new Parser(myLexer);
	myParser.parse();
}
