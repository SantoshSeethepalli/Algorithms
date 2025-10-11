package com.ArithmeticExpression.evaluator;

import java.util.*;

public class InfixEvaluator {

    private int getPrecedence(String operator) {

        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
//            case "(" -> 4;
            default -> 0;
        };
    }

    private boolean isOperator(String operator) {

        if(operator == null || operator.isEmpty()) return false;

        if(operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/")
                || operator.equals("^")) {

            return true;
        }

        return false;
    }

    private boolean isNumber(String number) {

        if(number == null || number.isEmpty()) return false;

        int start = (number.charAt(0) == '-') ? 1 : 0;

        if(start == 1 && number.length() == 1) return false;

        for(int idx = start; idx < number.length(); idx++) {

            char currentDigit = number.charAt(idx);
            if(!Character.isDigit(currentDigit)) return false;
        }

        return true;
    }

    private int applyOperation(int digit1, int digit2, String operator) {

        if(operator.equals("+")) return digit1 + digit2;
        else if(operator.equals("-")) return digit1 - digit2;
        else if(operator.equals("*")) return digit1 * digit2;
        else if(operator.equals("/")) return Math.floorDiv(digit1, digit2);
        else if(operator.equals("^")) return (int) Math.pow(digit1, digit2);
        else return 0;
    }

    public int evaluateInfix(String[] arr) {

        Stack<String> operatorsStack = new Stack<>();
        Stack<Integer> numbersStack = new Stack<>();

        for(String currentString : arr) {

            if(isNumber(currentString)) {

                numbersStack.push(Integer.parseInt(currentString));
            } else {

                if(!isOperator(currentString)) return 0;

                while(!operatorsStack.isEmpty() &&
                        ((getPrecedence(currentString)) <= getPrecedence(operatorsStack.peek()))) {

                    int digit2 = numbersStack.pop();
                    int digit1 = numbersStack.pop();
                    String operator = operatorsStack.pop();

                    numbersStack.push(applyOperation(digit1, digit2, operator));
                }

                operatorsStack.push(currentString);
            }
        }

        while(!operatorsStack.isEmpty()) {

            String currentOperator = operatorsStack.pop();
            int digit2 = numbersStack.pop();
            int digit1 = numbersStack.pop();

            numbersStack.push(applyOperation(digit1, digit2, currentOperator));
        }

        return numbersStack.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"100", "+", "200", "/", "2", "*", "5", "+", "-7"};

        System.out.println(new InfixEvaluator().evaluateInfix(arr));
    }
}
