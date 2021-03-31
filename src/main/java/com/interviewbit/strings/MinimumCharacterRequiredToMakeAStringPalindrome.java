package com.interviewbit.strings;

public class MinimumCharacterRequiredToMakeAStringPalindrome {

    public static void main(String[] args) {

        MinimumCharacterRequiredToMakeAStringPalindrome obj = new MinimumCharacterRequiredToMakeAStringPalindrome();
        System.out.println(obj.solve("AACECXAAAABUILDERAAABBBCCCAAA"));
    }

    public int solve(String A) {

        StringBuilder reverse = new StringBuilder(A).reverse();
        String finalString = A + "$" + reverse.toString();

        int n = finalString.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;

        while(i < n){

            if(finalString.charAt(i) == finalString.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{

                if(len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return A.length() - lps[n - 1];
    }
}
