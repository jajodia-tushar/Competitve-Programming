package com.interviewbit.math;

/*
Problem Description

Given a column title A as appears in an Excel sheet, return its corresponding column number.

Problem Constraints
1 <= |A| <= 100

Input Format
First and only argument is string A.

Output Format
Return an integer

Example Input
Input 1:

 1
Input 2:

 28

Example Output
Output 1:

 "A"
Output 2:
 "AB"

Example Explanation
Explanation 1:

 1 -> "A"
Explanation 2:

A  -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
 */
public class ExcelColumnNumber {

    public static void main(String[] args) {

        ExcelColumnNumber obj = new ExcelColumnNumber();
        int result = obj.titleToNumber("ZA");
        System.out.println(result);


    }

    public int titleToNumber(String A) {

        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            int ch = (A.charAt(i) - 'A') + 1;
            ans = ans * 26 + ch;
        }

        return ans;
    }
}

/*
    There is nothing much in this question as well.
    You will be given the String containing Characters you will need to transform to the actual column name as in Excel.

    So first thing you will need is the integer representation of individual character
    And now you just have to multiply the number with 26 every time you will see a next number.
    There are 26 characters so if you have 2 characters that means you more than 26 characters to represent.
    if your first character is A it means the character starts from 26 if it is 26 that means it starts from 26 * 2
    like wise.
    So you will have to multiply with 26 every time you see a number


 */
