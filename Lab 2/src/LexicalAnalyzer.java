import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer {
    InputStream is;
    int curChar;
    int curPos;
    Token curToken;
    public LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        curChar = ' ';
        curPos = 0;
        nextToken();
    }

    public boolean isEmpty(int c) {
        return (c == ' ') || (c == '\n') || (c == '\r') || (c == '\t');
    }

    public void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = is.read();
        }
        catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        nextChar();
        while (isEmpty(curChar)) {
            nextChar();
        }
        switch (curChar) {
            case ';':
                curToken = Token.SMC;
                break;
            case ':':
                curToken = Token.CLN;
                break;
            case ',':
                curToken = Token.COM;
                break;
            case 'v':
                curToken = Token.V;
                break;
            case 'a':
                curToken = Token.A;
                break;
            case 'r':
                curToken = Token.R;
                break;
            case -1:
                curToken = Token.END;
                break;
            default:
                curToken = Token.LET;
        }
    }

}
