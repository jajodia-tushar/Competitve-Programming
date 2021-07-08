package com.interviewbit.hashing;

import java.util.HashMap;

/*
Problem Description

Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.

Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.



Input Format
First argument is an string A.



Output Format
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Example Input
Input 1:

 A = "abcde"
Input 2:

 A = "abbaee"


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No possible rearrangement to make the string palindrome.
Explanation 2:

 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */
public class CheckPalindrome {

    public static void main(String[] args) {

        CheckPalindrome obj = new CheckPalindrome();
        int result = obj.solve("abccb");
        System.out.println(result);

    }

    public int solve(String A) {

        HashMap<Character, Integer> maps = new HashMap<>();
        for (Character ch : A.toCharArray()) {
            maps.put(ch, (maps.getOrDefault(ch, 0) + 1) % 2);
        }
        boolean flag = true;

        for (int value : maps.values()) {
            if (value == 1) {
                if (flag) flag = false;
                else return 0;
            }
        }
        return 1;
    }
}

/*
    Like this Question is nothing.
    Easy very easy


 */