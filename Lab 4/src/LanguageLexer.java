import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;

public class LanguageLexer {
    InputStream is;
    int curChar;
    LanguageToken curToken;
    int curPos;
    ArrayList<LanguageToken> tokens = new ArrayList<LanguageToken>();
    public String curName;
    public LanguageLexer(InputStream is) throws ParseException {
        this.is = is;
        curChar = ' ';
        nextChar();
        curPos = 0;
        nextToken();
    }

    private String curRead = "";

    public void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = is.read();
            curRead += (char)curChar;
        }
        catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        while (curChar == ' ') {
            nextChar();
        }
        if (curChar == -1) {
            curToken = LanguageToken.EOF;
        }
        if ("0".startsWith(curRead)) {
            while (("0".startsWith(curRead)) && ("0".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("0")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("1".startsWith(curRead)) {
            while (("1".startsWith(curRead)) && ("1".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("1")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("2".startsWith(curRead)) {
            while (("2".startsWith(curRead)) && ("2".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("2")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("3".startsWith(curRead)) {
            while (("3".startsWith(curRead)) && ("3".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("3")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("4".startsWith(curRead)) {
            while (("4".startsWith(curRead)) && ("4".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("4")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("5".startsWith(curRead)) {
            while (("5".startsWith(curRead)) && ("5".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("5")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("6".startsWith(curRead)) {
            while (("6".startsWith(curRead)) && ("6".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("6")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("7".startsWith(curRead)) {
            while (("7".startsWith(curRead)) && ("7".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("7")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("8".startsWith(curRead)) {
            while (("8".startsWith(curRead)) && ("8".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("8")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("9".startsWith(curRead)) {
            while (("9".startsWith(curRead)) && ("9".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("9")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("(".startsWith(curRead)) {
            while (("(".startsWith(curRead)) && ("(".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("(")) {
                curToken = LanguageToken.Token2;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if (")".startsWith(curRead)) {
            while ((")".startsWith(curRead)) && (")".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals(")")) {
                curToken = LanguageToken.Token3;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("*".startsWith(curRead)) {
            while (("*".startsWith(curRead)) && ("*".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("*")) {
                curToken = LanguageToken.Token1;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("+".startsWith(curRead)) {
            while (("+".startsWith(curRead)) && ("+".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("+")) {
                curToken = LanguageToken.Token0;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("DIGIT".startsWith(curRead)) {
            while (("DIGIT".startsWith(curRead)) && ("DIGIT".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("DIGIT")) {
                curToken = LanguageToken.DIGIT;
                curRead = "";                nextChar();
                return;
            }
        }
        else {
        if ("EOF".startsWith(curRead)) {
            while (("EOF".startsWith(curRead)) && ("EOF".length() < curRead.length())) {
                nextChar();
            }
            if (curRead.equals("EOF")) {
                curToken = LanguageToken.EOF;
                curRead = "";                nextChar();
                return;
            }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        }
        }
    }
}