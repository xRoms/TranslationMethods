import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        String exp = "var a, ds333, pompom: integer; zxy: double;";
        Tree s;
        try {
            s = new Parser(exp).Exp();
            Vizualize q = new Vizualize(s);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }
}
