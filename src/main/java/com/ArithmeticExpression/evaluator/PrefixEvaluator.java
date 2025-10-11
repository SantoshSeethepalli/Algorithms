package com.ArithmeticExpression.evaluator;

import java.util.*;

// Polish notation
public class PrefixEvaluator {

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

    public int evaluatePrefix(String[] arr) {

        int n = arr.length;
        Stack<Integer> rightToLeftStack = new Stack<>();

        for(int idx = n - 1; idx >= 0; idx--) {

            String currentString = arr[idx];

            if(currentString.charAt(0) == '-' && currentString.length() > 1 // Check for negative digit
                    || Character.isDigit(currentString.charAt(0))) { // or is it a positive digit

                rightToLeftStack.push(Integer.parseInt(currentString));
            } else {

                int firstDigit = rightToLeftStack.pop();
                int secondDigit = rightToLeftStack.pop();

                rightToLeftStack.push(applyOperator(firstDigit, secondDigit, currentString));
            }
        }

        return rightToLeftStack.pop();
    }
}
