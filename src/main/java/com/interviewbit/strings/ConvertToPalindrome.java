package com.interviewbit.strings;

/*
Problem Description

Given a string A consisting only of lowercase characters, we need to check whether it is possible to make this string a palindrome after removing exactly one character from this.

If it is possible then return 1 else return 0.



Problem Constraints
3 <= |A| <= 105

A[i] is always a lowercase character.



Input Format
First and only argument is an string A.



Output Format
Return 1 if it is possible to convert A to palindrome by removing exactly one character else return 0.



Example Input
Input 1:

 A = "abcba"
Input 2:

 A = "abecbea"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 We can remove character ‘c’ to make string palindrome
Explanation 2:

 It is not possible to make this string palindrome just by removing one character
 */
public class ConvertToPalindrome {

    boolean isMistakeAllowed;

    public static void main(String[] args) {

        ConvertToPalindrome obj = new ConvertToPalindrome();
        int result = obj.solve("abcba");
        System.out.println(result);

    }

    public int solve(String A) {
        int n = A.length();
        isMistakeAllowed = true;
        return checkRecursively(0, n - 1, A) ? 1 : 0;
    }

    public boolean checkRecursively(int start, int end, String A) {

        while (start <= end) {
            if (A.charAt(start) != A.charAt(end)) {
                if (isMistakeAllowed) {
                    isMistakeAllowed = false;
                    return checkRecursively(start + 1, end, A) ||
                            checkRecursively(start, end, A);
                } else return false;
            } else {
                start++;
                end--;
            }
        }

        int n = end - start + 1;

        if (isMistakeAllowed && n % 2 == 0) return false;

        return true;
    }
}

/*
    Nothing Serious here just think in terms of Two Pointer here.
 */