package com.interviewbit.math;


/*
Problem Description

Given a positive integer A, return its corresponding column title as appear in an Excel sheet.



Problem Constraints
1 <= A <= 1000000000



Input Format
First and only argument is integer A.



Output Format
Return a string, the answer to the problem.



Example Input
Input 1:

 A = 1
Input 2:

 A = 28


Example Output
Output 1:

 "A"
Output 2:

 "AB"


Example Explanation
Explanation 1:

 1 -> A
Explanation 2:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
 */
public class ExcelColumnTitle {

    public static void main(String[] args) {
        ExcelColumnTitle obj = new ExcelColumnTitle();
        String result = obj.convertToTitle(943566);
        System.out.println(result);
    }

    public String convertToTitle(int A) {
        StringBuilder str = new StringBuilder();
        while (A > 0) {

            int rem = A % 26;
            if (rem == 0) A--;
            char ch = giveMeChar(rem);
            str.insert(0, ch);
            A = A / 26;
        }
        return str.toString();
    }

    public char giveMeChar(int n) {
        if (n == 0)
            return 'Z';
        return (char) (64 + n);
    }
}

/*
    Just Do the opposite what you have done in the previous question.
    we will just need to handle the 'Z' case little differently.

 */
