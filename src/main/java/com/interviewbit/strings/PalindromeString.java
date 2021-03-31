package com.interviewbit.strings;

public class PalindromeString {

    public static void main(String[] args) {
        PalindromeString obj = new PalindromeString();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public int isPalindrome(String A) {
        A = A.replaceAll("[^0-9a-zA-z]+","").toLowerCase();
        int n = A.length();
        int i = 0;
        while(i < n/2 ){
            if(A.charAt(i) != A.charAt(n-1-i))
                return 0;
            i++;
        }
        return 1;
    }
}
