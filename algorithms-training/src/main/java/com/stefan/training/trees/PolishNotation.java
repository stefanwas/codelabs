package com.stefan.training.trees;

import java.util.Stack;

public class PolishNotation {

    // Odwrotna notacja polska albo Inverse Notation
    // (2+3) * (3+4) ->  2 3 + 3 4 + *
    // transformacja jest dość prosta: jeśli i-ty elemnt nie jest operatorem to odłóż go na stos, dla operatora zdejmij dwa ostatnie elementy
    // wykonaj operację i odłóż na stos


    public static void main(String[] args) {
//        String input = "2 3 + 3 4 + *";
//        String input = "2 3 + 4 +";
        String input = "2 10 + 3 / 14 3 - 4 * + 2 /";
        int output = calculate(input);
        System.out.println("OUT=" + output);

        String norm = normalize(input);
        System.out.println("NORM:" + norm);
    }

    private static Integer calculate(String input) throws IllegalArgumentException {

        String[] tokens = input.split(" ");

        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<tokens.length; i++) {
            if (isOperator(tokens[i])) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                Integer result = calc(b, a, tokens[i]);
                stack.push(result);

            } else {
                Integer value = Integer.parseInt(tokens[i]);
                stack.push(value);
            }
        }

        return stack.pop();
    }

    private static Integer calc(Integer a, Integer b, String operator) {
        if ("+".equals(operator)) {
            return a + b;
        }

        if ("-".equals(operator)) {
            return a - b;
        }

        if ("*".equals(operator)) {
            return a * b;
        }

        if ("/".equals(operator)) {
            return a / b;
        }

        throw  new IllegalArgumentException("Illegal operator: '" + operator + "'");
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }


    private static String normalize(String input) {

        String[] tokens = input.split(" ");

        Stack<String> stack = new Stack<String>();
        for (int i=0; i<tokens.length; i++) {
            if (isOperator(tokens[i])) {
                String a = stack.pop();
                String b = stack.pop();
                String result = "(" + b + " " + tokens[i] + " " + a + ")";
                stack.push(result);

            } else {
                stack.push(tokens[i]);
            }
        }
        return stack.pop();

    }

}
