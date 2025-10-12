package com.ArithmeticExpression.convertor;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.*;

public class Infix_To_Prefix {

    private boolean isRightAssociative(char operator) {

        return (operator == '^');
    }

    private int getPrecedence(char operator) {

        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }

    private boolean isOperand(char token) {

        return Character.isLetterOrDigit(token);
    }

    public String convertInfixToPrefix(String str) {

        // Stack should be maintained into decreasing order of precedence.
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder prefixExpression = new StringBuilder();

        for(int idx = str.length() - 1; idx >= 0; idx--) {

            char newToken = str.charAt(idx);

            if(isOperand(newToken)) {

                prefixExpression.append(newToken);
            } else if(newToken == ')') {

                operatorStack.push(newToken);
            } else if(newToken == '(') {

                while(!operatorStack.isEmpty() && operatorStack.peek() != ')') {

                    prefixExpression.append(operatorStack.pop());
                }

                if(!operatorStack.isEmpty()) operatorStack.pop(); //  remove ')'
            } else {

                while (!operatorStack.isEmpty() && operatorStack.peek() != ')' &&
                        (getPrecedence(operatorStack.peek()) > getPrecedence(newToken) ||
                            (getPrecedence(operatorStack.peek()) == getPrecedence(newToken) && !isRightAssociative(newToken)))) {

                    prefixExpression.append(operatorStack.pop());
                }

                operatorStack.push(newToken);
            }
        }

        while(!operatorStack.isEmpty()) {

            prefixExpression.append(operatorStack.pop());
        }

        return prefixExpression.reverse().toString();
    }

    public static void main(String[] args) {

        String infixExpression = "(A+B)*(C-D)^(E^F/G)";
        System.out.println(new Infix_To_Prefix().convertInfixToPrefix(infixExpression));
    }
}