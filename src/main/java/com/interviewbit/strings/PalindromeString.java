package com.interviewbit.strings;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Example:
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class PalindromeString {

    public static void main(String[] args) {
        PalindromeString obj = new PalindromeString();
        System.out.println(obj.isPalindromeX("1a2"));
    }

    public int isPalindrome(String A) {
        A = A.replaceAll("[^0-9a-zA-z]+", "").toLowerCase();
        int n = A.length();
        int i = 0;
        while (i < n / 2) {
            if (A.charAt(i) != A.charAt(n - 1 - i))
                return 0;
            i++;
        }
        return 1;
    }

    public int isPalindromeX(String A) {

        int n = A.length();
        int start = 0;
        int end = n - 1;
        while (start < end) {
            char left = Character.toLowerCase(A.charAt(start));
            char right = Character.toLowerCase(A.charAt(end));

            if (!Character.isAlphabetic(left) && !Character.isDigit(left)) {
                start++;
                continue;
            }
            if (!Character.isAlphabetic(right) && !Character.isDigit(right)) {
                end--;
                continue;
            }
            if (left != right) return 0;
            else
                System.out.println(left + " -- " + right);
            start++;
            end--;
        }
        return 1;
    }
}

/*
    There is nothing much in this question.

 */