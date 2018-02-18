import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class LanguageParser {
    public class pNode {
        public List<pNode> children;
        public String name;
        void addChild(pNode q) {
            children.add(q);
        }
        pNode(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
        String tostring(int cnt) {
            String out = "";
            for (int i = 0; i < cnt; i++) {
                out = out.concat("   ");
            }
            out = out.concat(name + "\n");
            for (pNode q : children) {
                out = out.concat(q.tostring(cnt + 1));
            }
            return out;
        }
    }

    private LanguageLexer lexer;
    public pNode parse(InputStream is) throws ParseException{
        lexer = new LanguageLexer(is);
        return e1();
    }

    void consume(LanguageToken s) throws ParseException {
        if (lexer.curToken != s) {
            throw new ParseException("wrong token", lexer.curPos);
        }
        lexer.nextToken();
    }
    pNode e1() throws ParseException {
        pNode cur = new pNode("e1");
        if (LanguageToken.Token2 == lexer.curToken || LanguageToken.DIGIT == lexer.curToken) {
            cur.addChild(t1());
            cur.addChild(e2());
            return cur;
        }
        throw new ParseException("idkwhathappenede1", 0);
    }
    pNode e2() throws ParseException {
        pNode cur = new pNode("e2");
        if (LanguageToken.Token0 == lexer.curToken) {
            consume(LanguageToken.Token0);
            cur.addChild(new pNode("+"));
            cur.addChild(t1());
            cur.addChild(e2());
            return cur;
        }
        else {
            if (LanguageToken.Token3 == lexer.curToken || LanguageToken.EOF == lexer.curToken) {
                cur.addChild(new pNode("EPS"));
                return cur;
        }
        }
        throw new ParseException("idkwhathappenede2", 0);
    }
    pNode t1() throws ParseException {
        pNode cur = new pNode("t1");
        if (LanguageToken.Token2 == lexer.curToken || LanguageToken.DIGIT == lexer.curToken) {
            cur.addChild(f());
            cur.addChild(t2());
            return cur;
        }
        throw new ParseException("idkwhathappenedt1", 0);
    }
    pNode t2() throws ParseException {
        pNode cur = new pNode("t2");
        if (LanguageToken.Token1 == lexer.curToken) {
            consume(LanguageToken.Token1);
            cur.addChild(new pNode("*"));
            cur.addChild(f());
            cur.addChild(t2());
            return cur;
        }
        else {
            if (LanguageToken.Token3 == lexer.curToken || LanguageToken.Token0 == lexer.curToken || LanguageToken.EOF == lexer.curToken) {
                cur.addChild(new pNode("EPS"));
                return cur;
        }
        }
        throw new ParseException("idkwhathappenedt2", 0);
    }
    pNode f() throws ParseException {
        pNode cur = new pNode("f");
        if (LanguageToken.DIGIT == lexer.curToken) {
            consume(LanguageToken.DIGIT);
            cur.addChild(new pNode("DIGIT"));
            return cur;
        }
        else {        if (LanguageToken.Token2 == lexer.curToken) {
            consume(LanguageToken.Token2);
            cur.addChild(new pNode("("));
            cur.addChild(e1());
            consume(LanguageToken.Token3);
            cur.addChild(new pNode(")"));
            return cur;
        }
        }
        throw new ParseException("idkwhathappenedf", 0);
    }
}