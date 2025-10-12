package com.ArithmeticExpression.convertor;

import java.util.Stack;

public class Prefix_To_Infix {

    private boolean isOperand(char c) {

        return Character.isLetterOrDigit(c);
    }

    private String getExpression(char operator, String firstOperand, String secondOperand) {

        return "(" + firstOperand + operator + secondOperand + ")";
    }

    public String convertPrefixToInfix(String prefixExpression) {

        int n = prefixExpression.length();
        Stack<String> stack = new Stack<>();

        for(int idx = n - 1; idx >= 0; idx--) {

            char c = prefixExpression.charAt(idx);

            if(isOperand(c)) {

                stack.push(c + "");
            } else {

                if(stack.size() < 2) return "";
                stack.push(getExpression(c, stack.pop(), stack.pop()));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String prefixExpression = "*+AB^-CD/^EFG";
        System.out.println(new Prefix_To_Infix().convertPrefixToInfix(prefixExpression));
    }
}
