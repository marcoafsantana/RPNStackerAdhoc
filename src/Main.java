import calc.RPN;
import utils.CheckType;
import stacker.rpn.Token;
import stacker.rpn.TokenType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        // Press ⌥⏎ with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Starting calculator:");

        try {
            List<Token> tokens = scan();
            RPN calculator = new RPN();
            int result;

            while (!tokens.isEmpty()) {
                Token token = tokens.remove(0);
                System.out.println(token);

                if (token.type == TokenType.NUM) {
                    calculator.saveRPN(token);
                } else if (token.type != TokenType.NUM) {
                    calculator.RpnStacker(token);
                }
            }

            result = calculator.getResult();
            System.out.println("\nSaida: " + result + "\n");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<Token> scan() throws FileNotFoundException {
        List<Token> tokens = new ArrayList<>();
        try {
            Scanner Scanner = new Scanner(new File("src/Calc1.stk"));

            while (Scanner.hasNextLine()) {
                String line = Scanner.nextLine().trim();

                Token token;

                if (line.equals("+")) {
                    token = new Token(TokenType.PLUS, line);
                } else if (line.equals("-")) {
                    token = new Token(TokenType.MINUS, line);
                } else if (line.equals("*")) {
                    token = new Token(TokenType.STAR, line);
                } else if (line.equals("/")) {
                    token = new Token(TokenType.SLASH, line);
                } else if (CheckType.isStringInt(line)) {
                    token = new Token(TokenType.NUM, line);
                } else {
                    Scanner.close();
                    throw new RuntimeException("Error: Unexpected character: " + line);
                }

                tokens.add(token);
            }

            Scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tokens;
    }
}