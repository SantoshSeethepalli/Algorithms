package com.ArithmeticExpression.convertor;

import java.util.Stack;

public class Postfix_To_Infix {

    private boolean isOperand(char c) {

        return Character.isLetterOrDigit(c);
    }

    private String getExpression(char operator, String secondOperand, String firstOperand) {

        return "(" + firstOperand + operator + secondOperand + ")";
    }

    public String convertPostfixToInfix(String postfixExpression) {

        Stack<String> stack = new Stack<>();

        for(char c : postfixExpression.toCharArray()) {

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

        String postfixExpression = "AB+CD-EF^G/^*";
        System.out.println(new Postfix_To_Infix().convertPostfixToInfix(postfixExpression));
    }
}
