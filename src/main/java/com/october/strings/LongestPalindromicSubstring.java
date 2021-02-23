package com.october.strings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome("bb"));
    }

    public String longestPalindrome(String A) {

        int subStringStart = -1;
        int maxValue = Integer.MIN_VALUE;

        //Odd Length
        for(int i = 0; i < A.length(); i++){
            int length = 1;
            int start = i - 1;
            int end = i + 1;
            while(isPalindrom(start,end,A)){
                start--;
                end++;
                length += 2;
            }

            if(length > maxValue){
                maxValue = length;
                subStringStart = start+1;
            }

            start = i - 1;
            end = i;
            length = 0;

            while(isPalindrom(start,end,A)){
                start--;
                end++;
                length += 2;
            }

            if(length > maxValue){
                maxValue = length;
                subStringStart = start + 1;
            }
        }

        return A.substring(subStringStart,maxValue+1);


    }

    public boolean isPalindrom(int start, int end, String A){
        return start >= 0 && end < A.length() && (A.charAt(start) == A.charAt(end));
    }
}
