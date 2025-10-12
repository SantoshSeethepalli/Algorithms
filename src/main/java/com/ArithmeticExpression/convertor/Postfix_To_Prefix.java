package com.ArithmeticExpression.convertor;

import java.util.Stack;

public class Postfix_To_Prefix {

    private boolean isOperand(char c) {

        return Character.isLetterOrDigit(c);
    }

    private String generatePrefixExpression(char operator, String secondOperand, String firstOperand) {

        return operator + firstOperand + secondOperand;
    }

    public String convertPostfixToPrefix(String postfixExpression) {

        Stack<String> stack = new Stack<>();

        for(char c :  postfixExpression.toCharArray()) {

            if(isOperand(c)) {

                stack.push(c + "");
            } else {

                if(stack.size() < 2) return "";
                stack.push(generatePrefixExpression(c, stack.pop(), stack.pop()));
            }
        }

        return (stack.size() == 1) ? stack.pop() : "";
    }

    public static void main(String[] args) {

        String prefixExpression = "AB+CD-EF^G/^*";
        System.out.println(new Postfix_To_Prefix().convertPostfixToPrefix(prefixExpression));
    }
}
