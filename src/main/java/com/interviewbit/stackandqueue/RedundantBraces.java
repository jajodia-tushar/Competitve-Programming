package com.interviewbit.stackandqueue;

import java.util.Stack;

/*
Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.

Check whether A has redundant braces or not.

Return 1 if A has redundant braces, else return 0.

Note: A will be always a valid expression.




Input Format

The only argument given is string A.
Output Format

Return 1 if string has redundant braces, else return 0.
For Example

Input 1:
    A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.

Input 2:
    A = "(a + (a + b))"
Output 2:
    0
    Explanation 2:
        (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {

    public static void main(String[] args) {
        RedundantBraces obj = new RedundantBraces();
        int result = obj.braces("(a+(a+b))");
        System.out.println(result);
    }

    public int braces(String A) {

        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == '(' || isOperator(ch)) {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() == '(') return 1;
                while (!stack.isEmpty() && stack.pop() != '(') ;
            }
        }
        return 0;
    }

    public boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
/*
    Typical Stack Problem
    If you get '(' or operator push in stack. If you get ')'
    See if you have operator or '(' in the peek of stack.

    If There is operator then it is fine else there is unnecessary braces.
 */
