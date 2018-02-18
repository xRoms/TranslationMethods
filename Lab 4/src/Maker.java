import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Maker {
    private String headercode;
    private String memberscode;
    private Map<String, Set<String>> first = new TreeMap<>();
    private Map<String, Set<String>> follow = new TreeMap<>();
    private Map<String, Node> terminals = new TreeMap<String, Node>();
    private List<String> token = new ArrayList<>();
    private Map<String, String> randomtoken = new TreeMap<>();
    private Map<String, Node> nonterms = new TreeMap<String, Node>();
    private List<String> nont = new ArrayList<>();
    private String startrule = "";
    private Deque<String> firstdeq = new ArrayDeque<>();
    private String gramName = "";

    public void read() {
        randomtoken.put("EOF", "EOF");
        CharStream in = CharStreams.fromString("");
        try {
            in = CharStreams.fromFileName("src/language.g4");
        }
        catch (IOException e) {
            System.out.println("nice" +e.getMessage());
        }
        ParserLexer lexer = new ParserLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserParser parser = new ParserParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        ParserBaseListener visitor = new ParserBaseListener() {
            private boolean start = true;

            @Override
            public void enterMtitle(ParserParser.MtitleContext cont) {
                gramName = cont.NONTERM().getText();
                gramName = gramName.substring(0, 1).toUpperCase() + gramName.substring(1);
            }

            @Override
            public void enterMnonterm(ParserParser.MnontermContext cont) {
                if (start) {
                    start = false;
                    startrule = cont.NONTERM().getText();
                }
                nont.add(cont.NONTERM().getText());
                Node current = nontByName(cont.NONTERM().getText());
                for (ParserParser.AnyruleContext acont: cont.anyrule()) {
                    List<Node> add = new ArrayList<>();
                    if (acont.anyrule1().size() == 0) {
                        add.add(termByName("EPS"));
                        current.out.add(add);
                        continue;
                    }
                    for (ParserParser.Anyrule1Context a1cont: acont.anyrule1()) {
                        if (a1cont.TERMINAL() != null) {
                            String q = a1cont.TERMINAL().getText();
                            add.add(termByName(q));
                        }
                        else {
                            if (a1cont.NONTERM() != null) {
                                String q = a1cont.NONTERM().getText();
                                add.add(nontByName(q));
                            }
                            else {
                                if (a1cont.STRING() != null) {
                                    String help = a1cont.STRING().getText();
                                    help = help.substring(1, help.length() - 1);
                                    termByName(help).isString = true;
                                    newToken(help);
                                    add.add(termByName(help));
                                }
                            }
                        }
                    }
                    current.out.add(add);
                }
            }

            @Override
            public void enterMterminal(ParserParser.MterminalContext cont) {
                System.out.println("niccu");
                token.add(cont.TERMINAL().getText());
                randomtoken.put(cont.TERMINAL().getText(), cont.TERMINAL().getText());
                Node current = termByName(cont.TERMINAL().getText());
                for (ParserParser.StringContext scont : cont.string()) {
                    List<Node> add = new ArrayList<>();
                    for (TerminalNode q : scont.STRING()) {
                        String help = q.getText();
                        help = help.substring(1, help.length() - 1);
                        add.add(termByName(help));
                        termByName(help).isString = true;
                    }
                    current.out.add(add);
                }
            }

            @Override
            public void enterMheader(ParserParser.MheaderContext cont) {
                headercode = cont.CODE().getText();
            }
            @Override
            public void enterMmembers(ParserParser.MmembersContext cont) {
                memberscode = cont.CODE().getText();
            }
        };
        walker.walk(visitor, parser.gramm());

    }
    private int tokencnt = 0;
    private void newToken(String name) {
        if (!randomtoken.containsKey(name)) {
            randomtoken.put(name, "Token" + Integer.toString(tokencnt));
        }
    tokencnt++;
    }

    private Node termByName(String name) {
        if (!terminals.containsKey(name)) {
            terminals.put(name, new Node(name));
        }
        return terminals.get(name);
    }
    private Node nontByName(String name) {
        if (!nonterms.containsKey(name)) {
            nonterms.put(name, new Node(name));
        }
        return nonterms.get(name);
    }

    private void makeLexer() {
        File lexer = new File("src/"+ gramName + "Lexer.java");

        Writer out;
        try {
            out = new PrintWriter(lexer);
            out.write("import java.io.IOException;\n" +
                    "import java.io.InputStream;\n" +
                    "import java.text.ParseException;\n" +
                    "import java.util.ArrayList;\n" +

                    "\n" +
                    "public class " + gramName + "Lexer {\n" +
                    "    InputStream is;\n" +
                    "    int curChar;\n" +
                    "    " + gramName +"Token curToken;\n" +
                    "    int curPos;\n" +
                    "    ArrayList<"+ gramName +"Token> tokens = new ArrayList<"+ gramName +"Token>();\n" +
                    "    public String curName;\n" +
                    "    public "+ gramName +"Lexer(InputStream is) throws ParseException {\n" +
                    "        this.is = is;\n" +
                    "        curChar = ' ';\n" +
                    "        nextChar();\n" +
                    "        curPos = 0;\n" +
                    "        nextToken();\n" +
                    "    }\n" +
                    "\n" +
                    "    private String curRead = \"\";\n" +
                    "\n" +
                    "    public void nextChar() throws ParseException {\n" +
                    "        curPos++;\n" +
                    "        try {\n" +
                    "            curChar = is.read();\n" +
                    "            curRead += (char)curChar;\n" +
                    "        }\n" +
                    "        catch (IOException e) {\n" +
                    "            throw new ParseException(e.getMessage(), curPos);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    public void nextToken() throws ParseException {\n" +
                    "        while (curChar == ' ') {\n" +
                    "            nextChar();\n" +
                    "        }\n" +
                    "        if (curChar == -1) {\n" +
                    "            curToken = LanguageToken.EOF;\n" +
                    "        }\n");
            int cnt = 0;
            for (String tok : token) {
                for (List<Node> lterm: termByName(tok).out) {
                    String term = "";
                    for (Node q : lterm) {
                        term = term.concat(q.name);
                    }
                    if (cnt > 0) {
                        out.write("        else {\n");
                    }
                    cnt++;
                    out.write("        if (\"" + term + "\".startsWith(curRead)) {\n" +
                            "            while ((\"" + term + "\".startsWith(curRead)) && (\"" + term + "\".length() < curRead.length())) {\n" +
                            "                nextChar();\n" +
                            "            }\n" +
                            "            if (curRead.equals(\"" + term + "\")) {\n" +
                            "                curToken = "+ gramName +"Token." + tok + ";\n" +
                            "                curRead = \"\";" +
                            "                nextChar();\n" +
                            "                return;\n" +
                            "            }\n" +
                            "        }\n");
                }
            }
            for (String tok : randomtoken.keySet()) {
                if (cnt > 0) {
                    out.write("        else {\n");
                }
                cnt++;
                out.write("        if (\"" + tok + "\".startsWith(curRead)) {\n" +
                        "            while ((\"" + tok + "\".startsWith(curRead)) && (\"" + tok + "\".length() < curRead.length())) {\n" +
                        "                nextChar();\n" +
                        "            }\n" +
                        "            if (curRead.equals(\"" + tok + "\")) {\n" +
                        "                curToken = "+ gramName +"Token." + randomtoken.get(tok) + ";\n" +
                        "                curRead = \"\";" +
                        "                nextChar();\n" +
                        "                return;\n" +
                        "            }\n" +
                        "        }\n");

            }
            for (int i = 0; i < cnt - 1; i++) {
                out.write("        }\n");
            }
            out.write("    }\n}");
            out.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage()+ "notnice");
        }
    }

    void makeToken() {
        File lexer = new File("src/" + gramName + "Token.java");

        Writer out;
        try {
            out = new PrintWriter(lexer);
            boolean flag = true;
            out.write("public enum "+ gramName +"Token {\n    ");
            for (String name : randomtoken.values()) {
                if (!flag) {
                    out.write(", ");
                }
                out.write(name);
                flag = false;
            }
            out.write("\n}");
            out.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean flag = false;

    void recCalcFirst() {
        if (firstdeq.isEmpty()) {
            return;
        }
        Node curr = nontByName(firstdeq.removeFirst());
        int cnt = curr.first.size();
        System.out.println(curr.name);
        if (!curr.visited) {
            curr.visited = true;
            for (List<Node> q : curr.out) {
                for (Node qq: q) {
                    if (qq.isString) {
                        curr.first.add(qq.name);
                        break;
                    }
                    if (isTerminal(qq)) {
                        curr.first.add(qq.name);
                        break;
                    }
                    curr.first.addAll(qq.first);
                    if (!qq.first.contains("EPS")) {
                        break;
                    }
                }
            }
        }
        if (curr.first.size() != cnt) {
            flag = true;
        }
        recCalcFirst();
    }

    boolean isTerminal(Node q) {
        return ('A'<=q.name.charAt(0) && q.name.charAt(0) <='Z');
    }

    void calcFirstFollow() {
        nontByName(startrule).follow.add("EOF");
        flag = true;
        while (flag) {
            for (String q: nont) {
                nontByName(q).visited = false;
            }
            flag = false;
            firstdeq.addAll(nont);
            recCalcFirst();
        }
        for (String q : nont) {
            for (List<Node> cur : nontByName(q).out) {
                for (int i = 0; i < cur.size(); i++) {
                    Node current = cur.get(i);
                    if (current.isString) {
                        continue;
                    }
                    if (isTerminal(current)) {
                        continue;
                    }
                    String scur = current.name;
                    int iter = i + 1;
                    boolean check = true;
                    while (iter < cur.size() && check) {
                        check = false;
                        Node look = cur.get(iter);
                        if (look.isString) {
                            nontByName(scur).follow.add(look.name);
                            break;
                        }
                        if (isTerminal(look)) {
                            nontByName(scur).follow.add(look.name);
                            break;
                        }
                        if (cur.get(iter).first.contains("EPS")) {
                            check = true;
                        }
                        nontByName(scur).follow.addAll(cur.get(iter).first);
                        iter++;
                    }
                    if (check) {
                        nontByName(scur).follow.add("EOF");
                    }
                }
            }
        }
        boolean mark = true;
        while (mark) {
            mark = false;
            for (String q : nont) {
                for (List<Node> var : nontByName(q).out) {
                    int i = var.size() - 1;
                    boolean inmark = true;
                    while (i >= 0 && inmark) {
                        if (isTerminal(var.get(i))) {
                            break;
                        }
                        if (var.get(i).isString) {
                            break;
                        }
                        inmark = var.get(i).first.contains("EPS");
                        String qname = var.get(i).name;
                        System.out.println(q + " " + qname);
                        int cnt = nontByName(qname).follow.size();
                        nontByName(qname).follow.addAll(nontByName(q).follow);
                        if (cnt != nontByName(qname).follow.size()) {
                            mark = true;
                        }
                        i--;
                    }
                }
            }
        }
        for (String q : nont) {
            nontByName(q).follow.remove("EPS");
        }
    }



    void makeParser() {
        File parser = new File("src/" + gramName + "Parser.java");

        Writer out;
        try {
            out = new PrintWriter(parser);
            out.write("import java.io.InputStream;\n" +
                    "import java.text.ParseException;\n" +
                    "import java.util.ArrayList;\n" +
                    "import java.util.List;\n" +
                    "\n" +
                    "\n" +
                    "public class "+ gramName +"Parser {\n" +
                    "    public class pNode {\n" +
                    "        public List<pNode> children;\n" +
                    "        public String name;\n" +
                    "        void addChild(pNode q) {\n" +
                    "            children.add(q);\n" +
                    "        }\n" +
                    "        pNode(String name) {\n" +
                    "            this.name = name;\n" +
                    "            children = new ArrayList<>();\n" +
                    "        }\n" +
                    "        String tostring(int cnt) {\n" +
                    "            for (int i = 0; i < cnt; i++) {\n" +
                    "                name = name.concat(\"   \");\n" +
                    "            }\n" +
                    "            String out = name + \"\\n\";\n" +
                    "            for (pNode q : children) {\n" +
                    "                name = name.concat(q.tostring(cnt + 1));\n" +
                    "            }\n" +
                    "            return out;\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    private "+ gramName +"Lexer lexer;\n" +
                    "    public pNode parse(InputStream is) throws ParseException{\n" +
                    "        lexer = new "+ gramName +"Lexer(is);\n" +
                    "        return " + startrule + "();\n" +
                    "    }\n" +
                    "\n" +
                    "    void consume("+ gramName +"Token s) throws ParseException {\n" +
                    "        if (lexer.curToken != s) {\n" +
                    "            throw new ParseException(\"wrong token\", lexer.curPos);\n" +
                    "        }\n" +
                    "        lexer.nextToken();\n" +
                    "    }\n");
            for (String srule: nont) {
                Node rule = nontByName(srule);
                out.write("    pNode " + srule + "() throws ParseException {\n" +
                        "        pNode cur = new pNode(\""+ srule + "\");\n");
                boolean firstt = true;
                boolean isEps = false;
                int cnt = 0;
                for (List<Node> prod : rule.out) {

                    boolean flag = true;
                    int iter = 0;
                    Set<String> curfirst = new HashSet<>();
                    while (iter < prod.size() && flag) {
                        if (isTerminal(prod.get(iter))) {
                            curfirst.add(prod.get(iter).name);
                            break;
                        }
                        if (prod.get(iter).isString) {
                            curfirst.add(prod.get(iter).name);
                            break;
                        }
                        flag = prod.get(iter).first.contains("EPS");
                        curfirst.addAll(prod.get(iter).first);
                        iter++;
                    }
                    if (curfirst.contains("EPS")) {
                        isEps = true;
                    }
                    if (curfirst.size() == 0 || (curfirst.size() == 1 && curfirst.contains("EPS"))) {
                        continue;
                    }
                    if (!firstt) {
                        out.write("        else {");
                        cnt++;
                    }
                    firstt = false;
                    out.write("        if (");
                    boolean qfirst = true;
                    for (String q : curfirst) {
                        if (q.equals("EPS")) {
                            continue;
                        }
                        if (!qfirst) {
                            out.write(" || ");
                        }
                        qfirst = false;
                        out.write(gramName + "Token." + randomtoken.get(q) + " == lexer.curToken");
                    }
                    out.write(") {\n");
                    for (Node nq : prod) {
                        if (isTerminal(nq) || nq.isString) {
                            out.write("            consume("+ gramName +"Token." + randomtoken.get(nq.name) + ");\n");
                            out.write("            cur.addChild(new pNode(\"" + nq.name + "\"));\n");
                        }
                        else {
                            out.write("            cur.addChild(" + nq.name + "());\n");
                        }
                    }
                    out.write("            return cur;\n        }\n");
                }
                if (isEps && rule.follow.size() > 0) {
                    out.write("        else {\n");
                    cnt++;
                    out.write("            if (");
                    boolean qfirst = true;
                    for (String q : rule.follow) {
                        if (!qfirst) {
                            out.write(" || ");
                        }
                        qfirst = false;
                        out.write(gramName +"Token." + randomtoken.get(q) + " == lexer.curToken");
                    }
                    out.write(") {\n                cur.addChild(new pNode(\"EPS\"));\n                return cur;\n");
                    cnt++;
                }
                for (int i = 0 ; i < cnt; i++) {
                    out.write("        }\n");
                }
                out.write("        throw new ParseException(\"idkwhathappened" + srule + "\", 0);\n");
                out.write("    }\n");
            }
            out.write("}");
            out.close();


        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void make() {
        makeLexer();
        makeToken();
        calcFirstFollow();
        for (String q : nont) {
            Node cur = nontByName(q);
            System.out.print(cur.name + "\n");
            for (List<Node> qq: cur.out) {
                System.out.print("|");
                for (Node w: qq) {
                    System.out.print(w.name);
                }
                System.out.print("\n");
            }
            System.out.print("first:");
            for (String qq: cur.first) {
                System.out.print(qq +  " ");
            }
            System.out.println();
            System.out.print("follow:");
            for (String qq: cur.follow) {
                System.out.print(qq +  " ");
            }
            System.out.println();
        }
        makeParser();

    }
}
