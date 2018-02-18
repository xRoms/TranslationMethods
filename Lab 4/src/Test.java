import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;

public class Test {
    public static void main(String args[]) {
        InputStream is = new ByteArrayInputStream("(1+2)*3".getBytes());
        LanguageParser parser = new LanguageParser();
        try {
            System.out.print(parser.parse(is).tostring(0));
        }
        catch (ParseException e) {
            System.err.print(e.getMessage());
        }
    }
}
