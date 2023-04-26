import calc.RPN;
import utils.CheckType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Press ⌥⏎ with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Starting calculator:");

        int result;
        int input;
        String operator;
        try {
            Scanner Scanner = new Scanner(new File("src/Calc1.stk"));
            RPN Stacker = new RPN();

            while (Scanner.hasNextLine()) {
                operator = Scanner.nextLine();

                if (CheckType.isStringInt(operator)) {
                    System.out.println("Number:   " + operator);
                    input = Integer.parseInt(operator);
                    Stacker.saveRPN(input);
                } else {
                    System.out.println("Operator: " + operator);
                    Stacker.RpnStacker(operator.charAt(0));
                }
            }

            result = Stacker.getResult();
            System.out.println("Result:  " + result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}