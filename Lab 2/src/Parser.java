import java.io.ByteArrayInputStream;
import java.text.ParseException;

public class Parser {
    static int cnt = 0;
    Parser(String exp) throws ParseException {
        lex = new LexicalAnalyzer(new ByteArrayInputStream(exp.getBytes()));
    }

    LexicalAnalyzer lex;

    boolean isLetter (Token x) {
        return x == Token.A || x == Token.V || x == Token.R || x == Token.LET;
    }

    Tree Exp() throws ParseException {
        switch (lex.curToken) {
            case V:
                lex.nextToken();
                if (lex.curToken != Token.A) {
                    throw new ParseException("expected var", 0);
                }
                lex.nextToken();
                if (lex.curToken != Token.R) {
                    throw new ParseException("expected var", 0);
                }
                lex.nextToken();
                Tree cont = Other();
                return new Tree("exp", Integer.toString(cnt++), new Tree("var", Integer.toString(cnt++)), cont);
            default:
                throw new ParseException("expected var", 0);
        }
    }

    Tree Other() throws ParseException {
        if (!isLetter(lex.curToken)) {
            throw new ParseException("expected letter", lex.curPos);
        }
        Tree type = Type();
        if (lex.curToken != Token.SMC) {
            throw new ParseException("expected semicolon", lex.curPos);
        }
        lex.nextToken();
        Tree type2 = aType();
        return new Tree("other", Integer.toString(cnt++), type, new Tree("; ", Integer.toString(cnt++)), type2);
    }
    Tree Type() throws  ParseException {
        if (!isLetter(lex.curToken)) {
            throw new ParseException("expected letter", lex.curPos);
        }
        Tree vars = Varname();
        if (lex.curToken != Token.CLN) {
            throw new ParseException("exected colon", lex.curPos);
        }
        lex.nextToken();
        Tree typename = Name();
        return new Tree("type", Integer.toString(cnt++), vars, new Tree(": ", Integer.toString(cnt++)), typename);
    }

    Tree Name() throws ParseException {
        if (!isLetter(lex.curToken)) {
            throw new ParseException("expected letter", lex.curPos);
        }
        String name = "";
        while (isLetter(lex.curToken)) {
            name = name.concat(Character.toString((char)lex.curChar));
            lex.nextToken();
        }
        return new Tree(name, Integer.toString(cnt++));
    }

    Tree Varname() throws ParseException {
        Tree name = Name();
        Tree nextnames = aVarname();
        return new Tree("varnames", Integer.toString(cnt++), name, nextnames);
    }

    Tree aVarname() throws ParseException {
        if (lex.curToken == Token.COM) {
            lex.nextToken();
            Tree name = Name();
            Tree nextnames = aVarname();
            return new Tree("avarnames", Integer.toString(cnt++), new Tree(", ", Integer.toString(cnt++)), name, nextnames);
        }
        else {
            if (lex.curToken != Token.CLN) {
                throw new ParseException("expected colon", lex.curPos);
            }
            return new Tree(null, Integer.toString(cnt++));
        }
    }

    Tree aType() throws  ParseException {
        if (lex.curToken == Token.END) {
            return new Tree(null, Integer.toString(cnt++));
        }
        if (!isLetter(lex.curToken)) {
            throw new ParseException("expected letter", lex.curPos);
        }
        Tree type = Type();
        if (lex.curToken != Token.SMC) {
            throw new ParseException("expected semicolon", lex.curPos);
        }
        lex.nextToken();
        Tree atype = aType();
        return new Tree("atype", Integer.toString(cnt++), type, new Tree("; ", Integer.toString(cnt++)), atype);
    }

}
