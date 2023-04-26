package calc;

import utils.Stack;

public class RPN {

    private Stack<Integer> operands;

    public RPN() {
        operands = new Stack<>();
    }

    public void saveRPN(Integer operand) {
        operands.add(operand);
    }

    public Integer RpnStacker(Character operator) {
        Integer firstValue = operands.pop();
        Integer secondValue = operands.pop();
        Integer result = 0;

        switch (operator) {
            case '+':
                result =  secondValue + firstValue;
                break;
            case '-':
                result = secondValue - firstValue;
                break;
            case '*':
                result = secondValue * firstValue;
                break;
            case '/':
                result = secondValue / firstValue;
                break;
        }
        operands.add(result);
        return result;
    }

    public Integer getResult() {
        return operands.pop();
    }

}