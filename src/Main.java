import calc.RPN;
import stacker.rpn.lexer.Regex;
import stacker.rpn.Token;
import stacker.rpn.TokenType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

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

                Token token = Regex.getToken(line);

                tokens.add(token);
            }

            Scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tokens;
    }
}