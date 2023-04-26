package stacker.rpn.lexer;

import stacker.rpn.Token;
import stacker.rpn.TokenType;

public class Regex {
    private static final String NUM_RGX = "(\\d)+";
    private static final String OPERATION_RGX = "(\\+|-|\\*|/)";
    private static final String PLUS_RGX = "(\\+)";
    private static final String MINUS_RGX = "(\\-)";
    private static final String STAR_RGX = "(\\*)";
    private static final String SLASH_RGX = "(/)";

    public static boolean isNum(String token) {
        return token.matches(NUM_RGX);
    }

    public static boolean isOP(String token) {
        return token.matches(OPERATION_RGX);
    }

    public static Token getToken(String line) {
        if(isNum(line)) {
            return new Token(TokenType.NUM, line);
        } else if (isOP(line)) {
            if (line.matches(PLUS_RGX)) {
                return new Token(TokenType.PLUS, line);
            } else if (line.matches(MINUS_RGX)) {
                return new Token(TokenType.MINUS, line);
            } else if (line.matches(STAR_RGX)) {
                return new Token(TokenType.STAR, line);
            } else if (line.matches(SLASH_RGX)) {
                return new Token(TokenType.SLASH, line);
            }
        }
        throw new RuntimeException("Error: Unexpected character: " + line);
    }
}