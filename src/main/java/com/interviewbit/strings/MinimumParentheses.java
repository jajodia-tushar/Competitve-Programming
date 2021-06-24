package com.interviewbit.strings;


import java.util.Stack;

/*
Given a string A of parentheses  ‘(‘ or ‘)’.
The task is to find minimum number of parentheses ‘(‘ or ‘)’ (at any positions) we must add to make the resulting parentheses string valid.

An string is valid if:
Open brackets must be closed by the corresponding closing bracket.
Open brackets must be closed in the correct order.

Problem Constraints
1 <= |A| <= 105

A[i] = '(' or A[i] = ')'

Input Format
First and only argument is an string A.

Output Format
Return a single integer denoting the minimum number of parentheses ‘(‘ or ‘)’ (at any positions) we must add in A to make the resulting parentheses string valid.


Example Input
Input 1:

 A = "())"
Input 2:

 A = "((("


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 One '(' is required at beginning.
Explanation 2:

 Three ')' is required at end.
 */

// YOU MIGHT NEED TO VISIT THIS CHECKAGAIN
public class MinimumParentheses {

    public static void main(String[] args) {
        MinimumParentheses obj = new MinimumParentheses();
        int result = obj.solve("(((");
        System.out.println(result);
    }

    public int solve(String A) {

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char ch : A.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else {
                if (stack.isEmpty()) count++;
                else stack.pop();
            }
        }

        return count + stack.size();
    }

    public int solveWithOutStack(String A) {

        int counter = 0;
        int answer = 0;

        for (char ch : A.toCharArray()) {
            if (ch == '(') counter++;
            else {
                counter--;
                if (counter < 0) {
                    counter = 0;
                    answer++;
                }
            }
        }
        return counter + answer;
    }
}
/*
    It is fairly easy to solve this one with Stack but then solving it without
    stack takes time.
    easy to solve doesn't have too much things on it.

 */
