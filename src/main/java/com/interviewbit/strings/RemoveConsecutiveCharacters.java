package com.interviewbit.strings;

/*
Problem Description

Given a string A and integer B, remove all consecutive same characters that have length exactly B.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= |A|



Input Format
First Argument is string A.

Second argument is integer B.



Output Format
Return a string after doing the removals.



Example Input
Input 1:

A = "aabcd"
B = 2
Input 2:

A = "aabbccd"
B = 2


Example Output
Output 1:

 "bcd"
Output 2:

 "d"


Example Explanation
Explanation 1:

 "aa" had length 2.
Explanation 2:

 "aa", "bb" and "cc" had length of 2.
 */
public class RemoveConsecutiveCharacters {

    public static void main(String[] args) {
        RemoveConsecutiveCharacters obj = new RemoveConsecutiveCharacters();
        String result = obj.solve("aabcd", 2);
        System.out.println(result);
    }


    public String solve(String A, int B) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        int n = A.length();
        while (i < n) {
            char ch = A.charAt(i);
            int j = i + 1;
            while (j < n && ch == A.charAt(j)) {
                j++;
            }

            if ((j - i) != B) {
                str.append(A.substring(i, j));
            }
            i = j;
        }
        return str.toString();
    }

}

/*
    This type of question are easy and used just to check your comfort ability with language.
 */