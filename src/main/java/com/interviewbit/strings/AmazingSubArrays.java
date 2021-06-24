package com.interviewbit.strings;

/*
You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
	Amazing substrings of given string are :
	1. A
	2. AB
	3. ABE
	4. ABEC
	5. E
	6. EC
	here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubArrays {

    public static void main(String[] args) {

    }

    public int solve(String A) {
        int n = A.length();
        int result = 0;
        int i = 0;
        while (i < n) {
            if (isAmazingChar(A.charAt(i)))
                result = (result + (n - i)) % 10003;
            i++;
        }
        return result % 10003;
    }

    public boolean isAmazingChar(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||
                ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}

/*
    Nothing in this Question


 */