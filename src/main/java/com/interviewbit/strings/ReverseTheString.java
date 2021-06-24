package com.interviewbit.strings;


/*
Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.

Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

If there are multiple spaces between words, reduce them to a single space in the reversed string.




Input Format

The only argument given is string A.
Output Format

Return the string A after reversing the string word by word.
For Example

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"
 */
public class ReverseTheString {

    public static void main(String[] args) {
        ReverseTheString obj = new ReverseTheString();
        String result = obj.solve(" The Man  is Gold  ");
        System.out.println(result);
    }

    public String solve(String A) {

        int n = A.length();
        if (n == 1 && A.charAt(0) != ' ') return A;
        int start = 0;

        while (start < n && A.charAt(start) == ' ') start++;

        int end = n - 1;
        while (end >= 0 && A.charAt(end) == ' ') end--;

        StringBuilder result = new StringBuilder();

        for (int i = end - 1; i >= start; i--) {
            if (A.charAt(i) == ' ' && A.charAt(i + 1) != ' ') {
                result.append(A.substring(i + 1, end + 1) + " ");
                end = i - 1;
            } else if (A.charAt(i) == ' ') {
                end = i - 1;
            }

            if (i == start) {
                result.append(A.substring(i, end + 1));
            }
        }

        return result.toString();
    }
}
/*
    Nothing much in this question.
    Just a lot of Edge cases.
    Start from End for opt

 */