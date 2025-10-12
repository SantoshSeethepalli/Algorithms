package com.ArithmeticExpression.convertor;

import java.util.Stack;

public class Infix_To_Postfix {

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

    public String convertInfixToPostfix(String infixExpression) {

        // Stack should be maintained into decreasing order of precedence.
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        for (char token : infixExpression.toCharArray()) {

            if (isOperand(token)) {

                postfixExpression.append(token);
            } else if(token == '(') {

                operatorStack.push(token);
            } else if(token == ')') {

                while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {

                    postfixExpression.append(operatorStack.pop());
                }

                if(!operatorStack.isEmpty()) operatorStack.pop(); //  remove '('
            } else {

                while (!operatorStack.isEmpty() && operatorStack.peek() != ')' &&
                            (getPrecedence(operatorStack.peek()) > getPrecedence(token) ||
                                ((getPrecedence(operatorStack.peek()) == getPrecedence(token)) && !isRightAssociative(token)))) {

                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {

            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
    }

    public static void main(String[] args) {

        String infixExpression = "(A+B)*(C-D)^(E^F/G)";
        System.out.println(new Infix_To_Postfix().convertInfixToPostfix(infixExpression));
    }
}