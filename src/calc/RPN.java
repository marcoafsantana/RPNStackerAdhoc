package calc;

import utils.Stack;
import stacker.rpn.Token;
import stacker.rpn.TokenType;

public class RPN {

    private Stack<Integer> operands;

    public RPN() {
        operands = new Stack<>();
    }

    public void saveRPN(Token token) throws RuntimeException {
        if (token.type == TokenType.NUM) {
            operands.add(Integer.valueOf(token.lexeme));
        } else {
            throw new RuntimeException("Operando Inválido");
        }
    }

    public Integer RpnStacker(Token token) throws RuntimeException {
        Integer firstValue = operands.pop();
        Integer secondValue = operands.pop();
        Integer result = 0;

        switch (token.type) {
            case PLUS:
                result =  secondValue + firstValue;
                break;
            case MINUS:
                result = secondValue - firstValue;
                break;
            case STAR:
                result = secondValue * firstValue;
                break;
            case SLASH:
                result = secondValue / firstValue;
                break;
            default:
                throw new RuntimeException("Error: Unexpected character");
        }
        operands.add(result);
        return result;
    }

    public Integer getResult() {
        return operands.pop();
    }

}