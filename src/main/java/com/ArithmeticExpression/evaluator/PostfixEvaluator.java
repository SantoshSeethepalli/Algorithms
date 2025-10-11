package com.ArithmeticExpression.evaluator;

import java.util.Stack;


// Reverse - Polish notation
public class PostfixEvaluator {

    private int applyOperator(int firstDigit, int secondDigit, String operator) {

        return switch (operator) {
            case "+" -> (firstDigit + secondDigit);
            case "-" -> (firstDigit - secondDigit);
            case "*" -> (firstDigit * secondDigit);
            case "/" -> (Math.floorDiv(firstDigit, secondDigit));
            case "^" -> ((int) Math.pow(firstDigit, secondDigit));
            default -> 0;
        };
    }

    public int evaluatePostfix(String[] arr) {

        Stack<Integer> leftToRightStack = new Stack<>();

        for(String currentString : arr) {

            if(currentString.charAt(0) == '-' && currentString.length() >1
                || Character.isDigit(currentString.charAt(0))) {

                leftToRightStack.push(Integer.parseInt(currentString));
            } else {

                int secondDigit = leftToRightStack.pop();
                int firstDigit = leftToRightStack.pop();

                leftToRightStack.push(applyOperator(firstDigit, secondDigit, currentString));
            }
        }

        return leftToRightStack.pop();
    }
}
