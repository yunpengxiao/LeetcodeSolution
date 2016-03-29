package Linkedin;

import java.util.Stack;

/**
 * Created by xyunpeng on 3/26/16.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();

        for (String s : tokens) {
            int a, b;
            switch (s) {
                case "+":
                    a = operand.pop();
                    b = operand.pop();
                    operand.push(a + b);
                    break;
                case "-":
                    a = operand.pop();
                    b = operand.pop();
                    operand.push(b - a);
                    break;
                case "*":
                    a = operand.pop();
                    b = operand.pop();
                    operand.push(a * b);
                    break;
                case "/":
                    a = operand.pop();
                    b = operand.pop();
                    operand.push(b / a);
                    break;
                default:
                    operand.push(Integer.valueOf(s));
            }
        }

        if (!operand.isEmpty()) {
            return operand.peek();
        } else {
            return 0;
        }
    }
}
