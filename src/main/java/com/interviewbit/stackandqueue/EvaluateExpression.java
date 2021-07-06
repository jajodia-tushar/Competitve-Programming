package com.interviewbit.stackandqueue;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.




Input Format

The only argument given is character array A.
Output Format

Return the value of arithmetic expression formed using reverse Polish Notation.
For Example

Input 1:
    A =   ["2", "1", "+", "3", "*"]
Output 1:
    9
Explaination 1:
    starting from backside:
    *: ( )*( )
    3: ()*(3)
    +: ( () + () )*(3)
    1: ( () + (1) )*(3)
    2: ( (2) + (1) )*(3)
    ((2)+(1))*(3) = 9

Input 2:
    A = ["4", "13", "5", "/", "+"]
Output 2:
    6
Explaination 2:
    +: ()+()
    /: ()+(() / ())
    5: ()+(() / (5))
    1: ()+((13) / (5))
    4: (4)+((13) / (5))
    (4)+((13) / (5)) = 6
 */
public class EvaluateExpression {

    public static void main(String[] args) {

        EvaluateExpression obj = new EvaluateExpression();
        String[] arr = {"2", "1", "+", "3", "*"};
        int result = obj.evalRPN(arr);
        System.out.println(result);

    }

    public int evalRPN(String[] A) {

        Stack<Integer> stack = new Stack<>();
        for (String ch : A) {
            if (isOperator(ch)) {
                int b = stack.pop();
                int a = stack.pop();
                int c = evaluate(a, b, ch);
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.peek();
    }

    public int evaluate(int a, int b, String ch) {
        if (ch.equals("+")) return a + b;
        else if (ch.equals("-")) return a - b;
        else if (ch.equals("*")) return a * b;
        else return a / b;
    }

    public boolean isOperator(String A) {
        return A.equals("+") || A.equals("-") ||
                A.equals("*") || A.equals("/");
    }
}

/*
    Given the expression is in Reverse Polish Notation meaning Post Fix
    Means that the operator are at the end and operand are in the starting.

    If you keep stack and push in the operands and when you find a operator
    you just have to pop last two from stack, evaluate and then push back to the
    stack.

    Simple One.

 */