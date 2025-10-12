package com.ArithmeticExpression.convertor;

import java.util.Stack;

public class Prefix_To_Postfix {

    private boolean isOperand(char c) {

        return Character.isLetterOrDigit(c);
    }

    private String generatePostfixExpression(char operator, String firstOperand, String secondOperand) {

        return firstOperand + secondOperand + operator;
    }

    public String convertPrefixToPostfix(String prefixExpression) {

        int n = prefixExpression.length();
        Stack<String> stack = new Stack<>();

        for(int idx = n - 1; idx >= 0; idx--) {

            char c = prefixExpression.charAt(idx);

            if(isOperand(c)) {

                stack.push(c + "");
            } else {

                if(stack.size() < 2) return "";
                stack.push(generatePostfixExpression(c, stack.pop(), stack.pop()));
            }
        }

        return (stack.size() == 1) ? stack.pop() : "";
    }

    public static void main(String[] args) {

        String prefixExpression = "*+AB^-CD/^EFG";
        System.out.println(new Prefix_To_Postfix().convertPrefixToPostfix(prefixExpression));
    }
}