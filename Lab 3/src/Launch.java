import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.*;

public class Launch {
    public static void main(String args[]) {
        CharStream in = CharStreams.fromString("var\n" +
                "a, b: integer;\n" +
                "begin\n" +
                "a := 4 + 67 / b;\n" +
                "write(a,' ',z + x - r, ' haha' , 'works');\n" +
                "end.");
        HelloLexer lexer = new HelloLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);
        parser.main_rule();
    }
}
